package com.tencent.mm.sdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFile {
    private static final String TAG = "MicroMsg.ReadConfig";
    private String filePath;
    private Properties propertie;

    public ConfigFile(String str) {
        InputStream inputStream = null;
        AppMethodBeat.i(158052);
        this.propertie = null;
        this.filePath = null;
        this.propertie = new Properties();
        this.filePath = str;
        try {
            inputStream = s.openRead(str);
            this.propertie.load(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(158052);
                    return;
                } catch (IOException e2) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                    AppMethodBeat.o(158052);
                    return;
                }
            }
        } catch (Exception e3) {
            Log.e(TAG, "Read File: %s Failed. [%s]", str, e3.getLocalizedMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(158052);
                    return;
                } catch (IOException e4) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                    AppMethodBeat.o(158052);
                    return;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", str, e5.getLocalizedMessage());
                }
            }
            AppMethodBeat.o(158052);
            throw th;
        }
        AppMethodBeat.o(158052);
    }

    public boolean saveValue(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(158053);
        OutputStream outputStream = null;
        try {
            outputStream = s.dw(this.filePath, false);
            this.propertie.setProperty(str, str2);
            this.propertie.store(outputStream, "");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                }
            }
        } catch (Exception e3) {
            Log.e(TAG, "Write File: %s Failed. [%s]", this.filePath, e3.getLocalizedMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                    z = false;
                } catch (IOException e4) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", this.filePath, e4.getLocalizedMessage());
                    z = false;
                }
            } else {
                z = false;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.e(TAG, "Close File: %s Failed. [%s]", this.filePath, e5.getLocalizedMessage());
                }
            }
            AppMethodBeat.o(158053);
            throw th;
        }
        AppMethodBeat.o(158053);
        return z;
    }

    public boolean saveValue(String str, long j2) {
        AppMethodBeat.i(158054);
        boolean saveValue = saveValue(str, String.valueOf(j2));
        AppMethodBeat.o(158054);
        return saveValue;
    }

    public boolean saveValue(String str, int i2) {
        AppMethodBeat.i(158055);
        boolean saveValue = saveValue(str, String.valueOf(i2));
        AppMethodBeat.o(158055);
        return saveValue;
    }

    public String getValue(String str) {
        AppMethodBeat.i(158056);
        if (this.propertie == null || !this.propertie.containsKey(str)) {
            AppMethodBeat.o(158056);
            return null;
        }
        String property = this.propertie.getProperty(str);
        AppMethodBeat.o(158056);
        return property;
    }

    public Long getLongValue(String str) {
        Long l = null;
        AppMethodBeat.i(158057);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.o(158057);
        } else {
            try {
                l = Long.valueOf(Long.parseLong(value));
                AppMethodBeat.o(158057);
            } catch (Exception e2) {
                Log.e(TAG, "getLongValue ParseLong : %s Failed. [%s]", value, e2.getLocalizedMessage());
                AppMethodBeat.o(158057);
            }
        }
        return l;
    }

    public Integer getIntegerValue(String str) {
        Integer num = null;
        AppMethodBeat.i(158058);
        String value = getValue(str);
        if (value == null) {
            AppMethodBeat.o(158058);
        } else {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
                AppMethodBeat.o(158058);
            } catch (Exception e2) {
                Log.e(TAG, "getIntegerValue ParseInteger : %s Failed. [%s]", value, e2.getLocalizedMessage());
                AppMethodBeat.o(158058);
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        AppMethodBeat.i(158059);
        String value = new ConfigFile(str).getValue(str2);
        AppMethodBeat.o(158059);
        return value;
    }

    public static Long getLongValue(String str, String str2) {
        AppMethodBeat.i(158060);
        Long longValue = new ConfigFile(str).getLongValue(str2);
        AppMethodBeat.o(158060);
        return longValue;
    }

    public static Integer getIntegerValue(String str, String str2) {
        AppMethodBeat.i(230500);
        Integer integerValue = new ConfigFile(str).getIntegerValue(str2);
        AppMethodBeat.o(230500);
        return integerValue;
    }

    public static long getLongValue(String str, String str2, long j2) {
        AppMethodBeat.i(230501);
        Long longValue = new ConfigFile(str).getLongValue(str2);
        if (longValue == null) {
            AppMethodBeat.o(230501);
            return j2;
        }
        long longValue2 = longValue.longValue();
        AppMethodBeat.o(230501);
        return longValue2;
    }

    public static int getIntValue(String str, String str2, int i2) {
        AppMethodBeat.i(230502);
        Integer integerValue = new ConfigFile(str).getIntegerValue(str2);
        if (integerValue == null) {
            AppMethodBeat.o(230502);
            return i2;
        }
        int intValue = integerValue.intValue();
        AppMethodBeat.o(230502);
        return intValue;
    }

    public static boolean saveValue(String str, String str2, String str3) {
        AppMethodBeat.i(158061);
        boolean saveValue = new ConfigFile(str).saveValue(str2, str3);
        AppMethodBeat.o(158061);
        return saveValue;
    }

    public static boolean saveValue(String str, String str2, long j2) {
        AppMethodBeat.i(158062);
        boolean saveValue = new ConfigFile(str).saveValue(str2, j2);
        AppMethodBeat.o(158062);
        return saveValue;
    }

    public static boolean saveValue(String str, String str2, int i2) {
        AppMethodBeat.i(230503);
        boolean saveValue = new ConfigFile(str).saveValue(str2, i2);
        AppMethodBeat.o(230503);
        return saveValue;
    }
}
