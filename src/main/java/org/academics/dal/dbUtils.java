package org.academics.dal;


import java.sql.*;
import java.time.LocalDate;


/**
 * This class is used to fetch data from the database pertaining to the Utility package
 */
public class dbUtils {
    private static final JDBCPostgreSQLConnection jdbc = JDBCPostgreSQLConnection.getInstance();
    private static final Connection conn = jdbc.getConnection();

    /**
     * Validates if the current date is within the start and end date of the event
     *
     * @param eventType   the event type
     * @param year        the year
     * @param semester    the semester
     * @param currentDate the current date
     * @return true if the current date is within the start and end date of the event, false otherwise
     * @throws SQLException if there is an error with database access
     */

    public static ResultSet validateEventTime(String eventType, int year, int semester, LocalDate currentDate) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT" + eventType + "_start_date, " + eventType + "_end_date FROM semester WHERE year = ? AND semester_number = ?");
        statement.setInt(1, year);
        statement.setInt(2, semester);
        ResultSet eventDetails = statement.executeQuery();
        return eventDetails;

    }

    /**
     * Returns the current session
     *
     * @param currentDate the current date
     * @return the current session
     * @throws SQLException if there is an error with database access
     */
    public static ResultSet getCurrentSession(LocalDate currentDate) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT semester.year, semester_number FROM semester WHERE start_date <= ? AND end_date >= ?");
        statement.setDate(1, Date.valueOf(currentDate));
        statement.setDate(2, Date.valueOf(currentDate));
        // Execute the query and get the result set
        return statement.executeQuery();
    }

    public static ResultSet getDepartmentIDs() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM departments", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return statement.executeQuery();
    }
}
