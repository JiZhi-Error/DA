package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClipboardHelper {
    public static final int ANDROID_API_LEVEL_11 = 11;
    public static final int ANDROID_API_LEVEL_8 = 8;
    private static final String TAG = "MicroMsg.ClipboardHelper";
    private static int lastCopyTxtHash;

    interface IClipboard {
        Intent getIntent(Context context);

        CharSequence getText(Context context);

        Uri getUri(Context context);

        void setIntent(Context context, CharSequence charSequence, Intent intent);

        void setText(Context context, CharSequence charSequence, CharSequence charSequence2);

        void setUri(Context context, CharSequence charSequence, Uri uri);
    }

    public static void setText(CharSequence charSequence) {
        AppMethodBeat.i(215344);
        setText(MMApplicationContext.getContext(), null, charSequence);
        AppMethodBeat.o(215344);
    }

    public static boolean setTextSwallowException(CharSequence charSequence) {
        AppMethodBeat.i(261883);
        try {
            setText(MMApplicationContext.getContext(), null, charSequence);
            AppMethodBeat.o(261883);
            return true;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(261883);
            return false;
        }
    }

    public static void setText(Context context, CharSequence charSequence) {
        AppMethodBeat.i(215345);
        setText(context, null, charSequence);
        AppMethodBeat.o(215345);
    }

    public static void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(215346);
        if (Build.VERSION.SDK_INT >= 11) {
            new ClipbroadHelperImpl30().setText(context, charSequence, charSequence2);
        } else {
            new ClipbroadHelperImplBelow30().setText(context, charSequence, charSequence2);
        }
        if (charSequence2 != null) {
            lastCopyTxtHash = charSequence2.toString().hashCode();
        }
        AppMethodBeat.o(215346);
    }

    public static boolean isCopyFromWX(CharSequence charSequence) {
        AppMethodBeat.i(215347);
        if (Util.isNullOrNil(charSequence) || lastCopyTxtHash == 0) {
            AppMethodBeat.o(215347);
            return false;
        } else if (charSequence.toString().hashCode() == lastCopyTxtHash) {
            AppMethodBeat.o(215347);
            return true;
        } else {
            AppMethodBeat.o(215347);
            return false;
        }
    }

    public static CharSequence getText() {
        AppMethodBeat.i(215348);
        CharSequence text = getText(MMApplicationContext.getContext());
        AppMethodBeat.o(215348);
        return text;
    }

    public static CharSequence getText(Context context) {
        CharSequence text;
        AppMethodBeat.i(215349);
        if (Build.VERSION.SDK_INT >= 11) {
            text = new ClipbroadHelperImpl30().getText(context);
        } else {
            text = new ClipbroadHelperImplBelow30().getText(context);
        }
        if (text == null) {
            Log.i("ClipboardHelper", "getText null");
            AppMethodBeat.o(215349);
            return "";
        }
        AppMethodBeat.o(215349);
        return text;
    }

    public static void setIntent(Context context, CharSequence charSequence, Intent intent) {
        AppMethodBeat.i(215350);
        if (Build.VERSION.SDK_INT >= 11) {
            new ClipbroadHelperImpl30().setIntent(context, charSequence, intent);
            AppMethodBeat.o(215350);
            return;
        }
        new ClipbroadHelperImplBelow30().setIntent(context, charSequence, intent);
        AppMethodBeat.o(215350);
    }

    public static Intent getIntent(Context context) {
        AppMethodBeat.i(215351);
        if (Build.VERSION.SDK_INT >= 11) {
            Intent intent = new ClipbroadHelperImpl30().getIntent(context);
            AppMethodBeat.o(215351);
            return intent;
        }
        Intent intent2 = new ClipbroadHelperImplBelow30().getIntent(context);
        AppMethodBeat.o(215351);
        return intent2;
    }

    public static void setUri(Context context, CharSequence charSequence, Uri uri) {
        AppMethodBeat.i(215352);
        if (Build.VERSION.SDK_INT >= 11) {
            new ClipbroadHelperImpl30().setUri(context, charSequence, uri);
            AppMethodBeat.o(215352);
            return;
        }
        new ClipbroadHelperImplBelow30().setUri(context, charSequence, uri);
        AppMethodBeat.o(215352);
    }

    public static Uri getUri(Context context) {
        AppMethodBeat.i(215353);
        if (Build.VERSION.SDK_INT >= 11) {
            Uri uri = new ClipbroadHelperImpl30().getUri(context);
            AppMethodBeat.o(215353);
            return uri;
        }
        Uri uri2 = new ClipbroadHelperImplBelow30().getUri(context);
        AppMethodBeat.o(215353);
        return uri2;
    }
}
