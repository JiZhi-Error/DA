package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import org.xwalk.core.XWalkEnvironment;

public class SettingsAboutMMHeaderPreference extends Preference {
    public String Dak = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(74017);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.j39);
        TextView textView = (TextView) view.findViewById(R.id.b2);
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
            textView.setText(MMApplicationContext.getResources().getString(R.string.gl7));
        }
        ((TextView) view.findViewById(R.id.b1)).setText(String.format("%s %s", "Version", this.Dak));
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference.AnonymousClass1 */
                private long Dal = 0;

                public final void onClick(View view) {
                    AppMethodBeat.i(74016);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    long nowMilliSecond = Util.nowMilliSecond();
                    if (this.Dal > nowMilliSecond || nowMilliSecond - this.Dal > 300) {
                        this.Dal = nowMilliSecond;
                        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(74016);
                        return;
                    }
                    this.Dal = nowMilliSecond;
                    Context context = SettingsAboutMMHeaderPreference.this.mContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("[ver  ] %s %08X\n", ChannelUtil.formatVersion(context, d.KyO, true), Integer.valueOf(d.KyO)));
                    sb.append(BuildInfo.info());
                    Object[] objArr = new Object[2];
                    objArr[0] = com.tencent.mm.loader.j.b.aKD();
                    objArr[1] = Integer.valueOf(com.tencent.mm.sdcard_migrate.b.bhQ(com.tencent.mm.loader.j.b.aKI()) ? 1 : 0);
                    sb.append(String.format("[storage] %s|%s\n", objArr));
                    sb.append(String.format("[cid  ] %d\n", Integer.valueOf(ChannelUtil.channelId)));
                    sb.append(String.format("[s.ver] %d\n", Integer.valueOf(ai.aft(0))));
                    sb.append(String.format("[t.ver] %d\n", Integer.valueOf(ai.aft(6))));
                    sb.append(String.format("[l.ver] %d %s\n", Integer.valueOf(ai.aft(1)), ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType()));
                    sb.append(String.format("[w.ver] %d\n", Integer.valueOf(ai.aft(3))));
                    sb.append(String.format("[box.ver] %d\n", Integer.valueOf(ai.aft(2))));
                    sb.append(String.format("[pardus.ver] %d\n", Integer.valueOf(ai.aft(5))));
                    sb.append(String.format("[r.ver] %s\n", BuildInfo.CLIENT_VERSION));
                    sb.append(String.format("[exp.ver] %s\n", SettingsAboutMMHeaderPreference.eSR()));
                    sb.append(String.format("[application] %s\n", SettingsAboutMMHeaderPreference.this.mContext.getPackageName()));
                    sb.append(String.format("[brands] %d %s\n", Integer.valueOf(WeChatBrands.UserInfo.xagreementId), WeChatBrands.AppInfo.lang));
                    sb.append("[xw.ver] ").append(XWalkEnvironment.getInstalledNewstVersion(MMApplicationContext.getContext())).append("\n");
                    TextView textView = new TextView(context);
                    textView.setText(sb);
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    textView.setTextColor(SettingsAboutMMHeaderPreference.this.mContext.getResources().getColor(R.color.FG_0));
                    textView.setTypeface(Typeface.MONOSPACE);
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
                    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMMHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74016);
                }
            });
        }
        AppMethodBeat.o(74017);
    }

    static /* synthetic */ String eSR() {
        AppMethodBeat.i(74018);
        com.tencent.mm.plugin.expansions.a.isEnabled();
        AppMethodBeat.o(74018);
        return "disabled";
    }
}
