package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IntentUtil {
    private static final String TAG = "MicroMsg.IntentUtil";

    public static int getIntExtra(Intent intent, String str, int i2) {
        AppMethodBeat.i(157564);
        if (intent == null) {
            AppMethodBeat.o(157564);
        } else {
            try {
                i2 = intent.getIntExtra(str, i2);
            } catch (Exception e2) {
                Log.e(TAG, "getIntExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157564);
        }
        return i2;
    }

    public static int getInt(Bundle bundle, String str, int i2) {
        AppMethodBeat.i(230307);
        if (bundle == null) {
            AppMethodBeat.o(230307);
        } else {
            try {
                i2 = bundle.getInt(str, i2);
            } catch (Exception e2) {
                Log.e(TAG, "getIntExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(230307);
        }
        return i2;
    }

    public static long getLongExtra(Intent intent, String str, long j2) {
        AppMethodBeat.i(230308);
        if (intent == null) {
            AppMethodBeat.o(230308);
        } else {
            try {
                j2 = intent.getLongExtra(str, j2);
            } catch (Exception e2) {
                Log.e(TAG, "getIntExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(230308);
        }
        return j2;
    }

    public static long getLong(Bundle bundle, String str, long j2) {
        AppMethodBeat.i(230309);
        if (bundle == null) {
            AppMethodBeat.o(230309);
        } else {
            try {
                j2 = bundle.getLong(str, j2);
            } catch (Exception e2) {
                Log.e(TAG, "getIntExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(230309);
        }
        return j2;
    }

    public static Bundle getExtras(Intent intent) {
        Bundle bundle = null;
        AppMethodBeat.i(157567);
        if (intent == null) {
            AppMethodBeat.o(157567);
        } else {
            try {
                bundle = intent.getExtras();
            } catch (Exception e2) {
                Log.e(TAG, "getExtras exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157567);
        }
        return bundle;
    }

    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        AppMethodBeat.i(157568);
        if (intent == null) {
            AppMethodBeat.o(157568);
        } else {
            try {
                z = intent.getBooleanExtra(str, z);
            } catch (Exception e2) {
                Log.e(TAG, "getBooleanExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157568);
        }
        return z;
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        AppMethodBeat.i(230310);
        if (bundle == null) {
            AppMethodBeat.o(230310);
        } else {
            try {
                z = bundle.getBoolean(str, z);
            } catch (Exception e2) {
                Log.e(TAG, "getBooleanExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(230310);
        }
        return z;
    }

    public static String getStringExtra(Intent intent, String str) {
        String str2 = null;
        AppMethodBeat.i(157569);
        if (intent == null) {
            AppMethodBeat.o(157569);
        } else {
            try {
                str2 = intent.getStringExtra(str);
            } catch (Exception e2) {
                Log.e(TAG, "getStringExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157569);
        }
        return str2;
    }

    public static String getString(Bundle bundle, String str) {
        String str2 = null;
        AppMethodBeat.i(157570);
        if (bundle == null) {
            AppMethodBeat.o(157570);
        } else {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e2) {
                Log.e(TAG, "getStringExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157570);
        }
        return str2;
    }

    public static byte[] getByteArrayExtra(Intent intent, String str) {
        byte[] bArr = null;
        AppMethodBeat.i(157571);
        if (intent == null) {
            AppMethodBeat.o(157571);
        } else {
            try {
                bArr = intent.getByteArrayExtra(str);
            } catch (Exception e2) {
                Log.e(TAG, "getByteArrayExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157571);
        }
        return bArr;
    }

    public static Parcelable getParcelableExtra(Intent intent, String str) {
        Parcelable parcelable = null;
        AppMethodBeat.i(157572);
        if (intent == null) {
            AppMethodBeat.o(157572);
        } else {
            try {
                parcelable = intent.getParcelableExtra(str);
            } catch (Exception e2) {
                Log.e(TAG, "getParcelableExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(157572);
        }
        return parcelable;
    }

    public static byte[] getByteArray(Bundle bundle, String str) {
        byte[] bArr = null;
        AppMethodBeat.i(230311);
        if (bundle == null) {
            AppMethodBeat.o(230311);
        } else {
            try {
                bArr = bundle.getByteArray(str);
            } catch (Exception e2) {
                Log.e(TAG, "getByteArrayExtra exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(230311);
        }
        return bArr;
    }

    public static void putExtra(Intent intent, String str, boolean z) {
        AppMethodBeat.i(157573);
        try {
            intent.putExtra(str, z);
            AppMethodBeat.o(157573);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(157573);
        }
    }

    public static void putExtra(Intent intent, String str, int i2) {
        AppMethodBeat.i(230312);
        try {
            intent.putExtra(str, i2);
            AppMethodBeat.o(230312);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(230312);
        }
    }
}
