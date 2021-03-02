package com.tencent.mm.ui.matrix;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Process;
import android.support.v4.e.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import java.util.Locale;

public class MatrixSettingHeaderPreference extends Preference {
    a QmP;

    /* access modifiers changed from: package-private */
    public interface a {
        void gWW();
    }

    public MatrixSettingHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MatrixSettingHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(38882);
        super.onBindView(view);
        final ImageView imageView = (ImageView) view.findViewById(R.id.fb2);
        ((TextView) view.findViewById(R.id.fb3)).setText(BuildInfo.MATRIX_VERSION);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference.AnonymousClass1 */
            int clickCount = 3;
            Toast xfv;

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(38881);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (MatrixSettingHeaderPreference.this.QmP == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(38881);
                } else {
                    this.clickCount--;
                    if (this.xfv == null) {
                        this.xfv = Toast.makeText(MatrixSettingHeaderPreference.this.mContext, MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.string.eyl, Integer.valueOf(this.clickCount)), 1);
                    }
                    if (this.clickCount <= 0) {
                        this.xfv.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.string.eyk));
                    } else {
                        this.xfv.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(R.string.eyl, Integer.valueOf(this.clickCount)));
                    }
                    ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.1f, 0.9f), Keyframe.ofFloat(0.2f, 0.9f), Keyframe.ofFloat(0.3f, 1.1f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.5f, 1.1f), Keyframe.ofFloat(0.6f, 1.1f), Keyframe.ofFloat(0.7f, 1.1f), Keyframe.ofFloat(0.8f, 1.1f), Keyframe.ofFloat(0.9f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.1f, 0.9f), Keyframe.ofFloat(0.2f, 0.9f), Keyframe.ofFloat(0.3f, 1.1f), Keyframe.ofFloat(0.4f, 1.1f), Keyframe.ofFloat(0.5f, 1.1f), Keyframe.ofFloat(0.6f, 1.1f), Keyframe.ofFloat(0.7f, 1.1f), Keyframe.ofFloat(0.8f, 1.1f), Keyframe.ofFloat(0.9f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, -3.0f), Keyframe.ofFloat(0.2f, -3.0f), Keyframe.ofFloat(0.3f, 3.0f), Keyframe.ofFloat(0.4f, -3.0f), Keyframe.ofFloat(0.5f, 3.0f), Keyframe.ofFloat(0.6f, -3.0f), Keyframe.ofFloat(0.7f, 3.0f), Keyframe.ofFloat(0.8f, -3.0f), Keyframe.ofFloat(0.9f, 3.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration(1000L).start();
                    this.xfv.show();
                    if (this.clickCount == 0 && MatrixSettingHeaderPreference.this.QmP != null) {
                        MatrixSettingHeaderPreference.this.QmP.gWW();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(38881);
                }
                return true;
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference.AnonymousClass2 */
            private long Dal = 0;

            public final void onClick(View view) {
                AppMethodBeat.i(234460);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                long nowMilliSecond = Util.nowMilliSecond();
                if (this.Dal > nowMilliSecond || nowMilliSecond - this.Dal > 300) {
                    this.Dal = nowMilliSecond;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(234460);
                    return;
                }
                this.Dal = nowMilliSecond;
                Context context = view.getContext();
                StringBuilder sb = new StringBuilder();
                sb.append("[ver  ] ").append(String.format(Locale.ENGLISH, "%s %08X", ChannelUtil.formatVersion(context, d.KyO, true), Integer.valueOf(d.KyO))).append("\n");
                sb.append(BuildInfo.info());
                com.tencent.matrix.a.b bVar2 = (com.tencent.matrix.a.b) com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
                if (bVar2 != null) {
                    c cVar = (c) bVar2.cQh.aa(c.class);
                    if (cVar != null) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(Process.myPid()));
                        ActivityManager activityManager = (ActivityManager) MatrixSettingHeaderPreference.this.mContext.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                        if (activityManager != null) {
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                if (runningAppProcessInfo.processName.contains(MatrixSettingHeaderPreference.this.mContext.getPackageName()) && !sb2.toString().contains(String.valueOf(runningAppProcessInfo.pid))) {
                                    sb2.append("|").append(runningAppProcessInfo.pid);
                                }
                            }
                        }
                        sb.append("[bat.pids  ] ").append(sb2.toString()).append("\n");
                        c.b bb = cVar.bb(0);
                        sb.append("[bat.dice  ] ").append(com.tencent.matrix.c.a.SA() ? 1 : 0).append("\n");
                        sb.append("[bat.uptime] ").append(bb.cSM.cTz).append("\n");
                        sb.append("[bat.fg    ] ").append(bb.cSN.cTz).append("\n");
                        sb.append("[bat.bg    ] ").append(bb.cSO.cTz).append("\n");
                        sb.append("[bat.fgSrv ] ").append(bb.cSP.cTz).append("\n");
                        h.b bc = cVar.bc(0);
                        List<k<String, Integer>> subList = bc.cUx.subList(0, Math.min(bc.cUx.size(), 3));
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            k<String, Integer> kVar = subList.get(i2);
                            sb.append("[bat.uiTop").append(i2 + 1).append("] ").append((String) kVar.first).append(FilePathGenerator.ANDROID_DIR_SEP).append((Object) kVar.second).append("\n");
                        }
                    }
                    com.tencent.matrix.a.b.a.d dVar = (com.tencent.matrix.a.b.a.d) bVar2.cQh.aa(com.tencent.matrix.a.b.a.d.class);
                    if (dVar != null) {
                        d.C0208d bd = dVar.bd(0);
                        sb.append("[bat.charge] ").append(bd.cTb.cTz).append("\n");
                        sb.append("[bat.dim   ] ").append(bd.cTc.cTz).append("\n");
                    }
                }
                TextView textView = new TextView(context);
                textView.setText(sb);
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                textView.setTextColor(MatrixSettingHeaderPreference.this.mContext.getResources().getColor(R.color.FG_0));
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                com.tencent.mm.ui.base.h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(234460);
            }
        });
        AppMethodBeat.o(38882);
    }
}
