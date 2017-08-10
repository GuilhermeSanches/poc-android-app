package br.com.android.pocapp.domain;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootInfo {

    /**
     * Time of event
     */
    private String mTime;

    /**
     * Type of event
     */
    private Integer mType;


    /**
     * getters and setters
     * @return
     */
    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public Integer getmType() {
        return mType;
    }

    /**
     * Constructor of model
     * @param mType
     */
    public void setmType(Integer mType) {
        this.mType = mType;
    }
}
