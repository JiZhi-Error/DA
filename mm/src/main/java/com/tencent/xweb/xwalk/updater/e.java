package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.p;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    static boolean SJm = false;

    public static boolean isBusy() {
        AppMethodBeat.i(207357);
        Log.i("XWalkCleaner", "XWalkCleaner busy == " + SJm);
        boolean z = SJm;
        AppMethodBeat.o(207357);
        return z;
    }

    public static void lJ(Context context) {
        AppMethodBeat.i(207358);
        new a(context).execute(new String[0]);
        SJm = true;
        AppMethodBeat.o(207358);
    }

    /* access modifiers changed from: package-private */
    public static class a extends AsyncTask<String, Integer, String> {
        Context mContext;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* bridge */ /* synthetic */ void onPostExecute(String str) {
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(207355);
            super.onPreExecute();
            AppMethodBeat.o(207355);
        }

        public a(Context context) {
            this.mContext = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ String doInBackground(String[] strArr) {
            AppMethodBeat.i(207356);
            Log.i("XWalkCleaner", "XWalkCleaner tryClean start");
            if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersionForCurAbi())) {
                p.Et(false);
            }
            p.huY();
            p.L(this.mContext, false);
            p.lG(this.mContext);
            p.huW();
            e.SJm = false;
            Log.i("XWalkCleaner", "XWalkCleaner tryClean finished");
            AppMethodBeat.o(207356);
            return null;
        }
    }
}
