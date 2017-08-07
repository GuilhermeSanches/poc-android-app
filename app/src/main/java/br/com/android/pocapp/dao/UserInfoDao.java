package br.com.android.pocapp.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.android.pocapp.constants.ConstantsUserInfoTable;
import br.com.android.pocapp.entity.UserEntity;

/**
 * Created by guilherme.sanches on 07/08/2017.
 * Class of methods CRUD of the table UserInfo
 */
public class UserInfoDao extends PocDao {

    /**
     * Constructor of class
     *
     * @param context of app
     */
    public UserInfoDao(Context context) {
        super(context);
    }

    /**
     * @param user info
     * @return True if user was successfully inserted or False if not
     */
    public final boolean insertUserInfo(UserEntity user){
        ContentValues values;
        boolean result;

        values = new ContentValues();
        values.put(ConstantsUserInfoTable.COLUMN_USERNAME,
                user.getmUserName());
        values.put(ConstantsUserInfoTable.COLUMN_EMAIL,
                user.getmUserEmail());
        values.put(ConstantsUserInfoTable.COLUMN_PHONE,
                user.getmUserPhone());
        values.put(ConstantsUserInfoTable.COLUMN_CPF,
                user.getmUserCpf());
        values.put(ConstantsUserInfoTable.COLUMN_PASSWORD,
                user.getmUserPassword());
        return true ? database.insert(ConstantsUserInfoTable.TABLE_USER_INFO, null, values)
                    != -1 : false;
    }
}
