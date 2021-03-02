package com.tencent.mm.plugin.choosemsgfile.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.choosemsgfile.compat.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;

public final class a implements com.tencent.mm.choosemsgfile.compat.a {
    @Override // com.tencent.mm.choosemsgfile.compat.a
    public final void g(Context context, String str, String str2) {
        AppMethodBeat.i(123222);
        ChooseMsgFileShowUI.t(context, str, str2);
        AppMethodBeat.o(123222);
    }

    @Override // com.tencent.mm.choosemsgfile.compat.a
    public final void a(MMActivity mMActivity, String str, String str2, int i2, String str3, a.AbstractC0293a aVar) {
        AppMethodBeat.i(123223);
        if ("file".equals(str2)) {
            ChooseMsgFileListUI.a(mMActivity, str, i2, str3, aVar);
            AppMethodBeat.o(123223);
            return;
        }
        ChooseMsgFileUI.a(mMActivity, str, str2, i2, str3, aVar);
        AppMethodBeat.o(123223);
    }

    @Override // com.tencent.mm.choosemsgfile.compat.a
    public final void a(Activity activity, String str, int i2, String str2, final a.AbstractC0293a aVar) {
        AppMethodBeat.i(170096);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 11);
        intent.putExtra("Select_Conv_ui_title", activity.getString(R.string.b40));
        intent.putExtra("KChooseMsgFileType", str);
        intent.putExtra("KChooseMsgFileCount", i2);
        intent.putExtra("KChooseMsgFileExtension", str2);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.dq);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        final AnonymousClass1 r2 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(123221);
                Log.i("MicroMsg.ChooseMsgFileService", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                Log.d("MicroMsg.ChooseMsgFileService", "data:%s", intent);
                c.a(i2, i3, intent, aVar);
                AppMethodBeat.o(123221);
            }
        };
        if (activity instanceof f.e) {
            f.aK(activity).b(new f.c() {
                /* class com.tencent.mm.plugin.choosemsgfile.b.a.AnonymousClass2 */

                @Override // com.tencent.luggage.h.f.c
                public final boolean c(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(170094);
                    if (b.qoN == i2) {
                        r2.d(i2, i3, intent);
                        AppMethodBeat.o(170094);
                        return true;
                    }
                    AppMethodBeat.o(170094);
                    return false;
                }
            });
        } else if (activity instanceof MMActivity) {
            ((MMActivity) activity).mmSetOnActivityResultCallback(r2);
        } else if (activity instanceof MMFragmentActivity) {
            ((MMFragmentActivity) activity).setMMOnFragmentActivityResult(new MMFragmentActivity.b() {
                /* class com.tencent.mm.plugin.choosemsgfile.b.a.AnonymousClass3 */

                @Override // com.tencent.mm.ui.MMFragmentActivity.b
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(170095);
                    r2.d(i2, i3, intent);
                    AppMethodBeat.o(170095);
                }
            });
        }
        com.tencent.mm.br.c.c(activity, ".ui.transmit.SelectConversationUI", intent, b.qoN);
        AppMethodBeat.o(170096);
    }
}
