package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public final class y {

    public static class a {
        public ArrayList<String> IN;
        public ArrayList<String> IP;
        public ArrayList<String> IQ;
        public ArrayList<Uri> IR;
        private Activity mActivity;
        public Intent mIntent = new Intent().setAction("android.intent.action.SEND");

        public a(Activity activity) {
            this.mActivity = activity;
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", activity.getComponentName());
            this.mIntent.addFlags(524288);
        }

        public final void b(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, strArr);
        }
    }
}
