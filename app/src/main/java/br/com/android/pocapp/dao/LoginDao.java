package br.com.android.pocapp.dao;

import android.content.Context;
import android.database.Cursor;

import br.com.android.pocapp.constants.ConstantsUserInfoTable;
import br.com.android.pocapp.dao.factory.FactoryDao;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class LoginDao {

    private FactoryDao mFactoryDao;
    /**
     * Constructor of class
     *
     * @param context of app
     */
    public LoginDao(Context context) {
        mFactoryDao = new FactoryDao(context);
    }

    /**
     * Method that check email and password to login in app
     * @param email
     * @param password
     * @return boolean if login did sucess
     */
    public boolean getUser(String email, String password) {

        String selection =
                ConstantsUserInfoTable.COLUMN_EMAIL     + " = ?" + " AND " +
                        ConstantsUserInfoTable.COLUMN_PASSWORD  + " = ?";

        // arguments
        String[] selectionArgs = {email, password};

        // columns to be returned
        String[] columns = {
                ConstantsUserInfoTable.COLUMN_ID
        };

        // Query user in table
        Cursor cursor = mFactoryDao.getDatabase().query(
                //Table to query
                ConstantsUserInfoTable.TABLE_USER_INFO,
                //columns to be returned
                columns,
                //columns in WHERE
                selection,
                //The values for the WHERE clause
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean doLogin(String email, String password ) {
        return getUser(email, password);
    }
}
