package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import java.util.Date;
import java.util.Locale;

public class MetadataItem {
    protected String dataType;
    private byte[] dataValue;
    private Date dateValue;
    protected CMTime duration;
    protected String extendedLanguageTag;
    protected String identifier;
    protected Locale locale;
    private Integer numberValue;
    private Date startDate;
    private String stringValue;
    protected CMTime time;
    protected Object value;

    public String getIdentifier() {
        return this.identifier;
    }

    public String getExtendedLanguageTag() {
        return this.extendedLanguageTag;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public CMTime getTime() {
        return this.time;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public String getDataType() {
        return this.dataType;
    }

    public Object getValue() {
        return this.value;
    }

    public static class MutableMetadataItem extends MetadataItem {
        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public void setExtendedLanguageTag(String str) {
            this.extendedLanguageTag = str;
        }

        public void setLocale(Locale locale) {
            this.locale = locale;
        }

        public void setTime(CMTime cMTime) {
            this.time = cMTime;
        }

        public void setDuration(CMTime cMTime) {
            this.duration = cMTime;
        }

        public void setDataType(String str) {
            this.dataType = str;
        }

        public void setValue(Object obj) {
            this.value = obj;
        }
    }
}
