package com.tencent.mm.plugin.finder.activity.uic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "acknowledgeBtn", "Landroid/widget/Button;", "container", "Landroid/widget/LinearLayout;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1;", "invalidDetailIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "invalidDetailText", "Landroid/widget/TextView;", "changeFeed", "", "responseCode", "", "initView", "type", "errMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderInvalidActivityUIC extends UIComponent {
    public static final a tsa = new a((byte) 0);
    LinearLayout tmh;
    Button trW;
    TextView trX;
    WeImageView trY;
    private final b trZ = new b(this);

    static {
        AppMethodBeat.i(242152);
        AppMethodBeat.o(242152);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderInvalidActivityUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242151);
        AppMethodBeat.o(242151);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(242149);
        super.onCreate(bundle);
        this.trZ.alive();
        AppMethodBeat.o(242149);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242150);
        super.onDestroy();
        this.trZ.dead();
        AppMethodBeat.o(242150);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$2$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ FinderInvalidActivityUIC tsb;

        c(FinderInvalidActivityUIC finderInvalidActivityUIC) {
            this.tsb = finderInvalidActivityUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242148);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.tsb.getActivity().isFinishing()) {
                this.tsb.getActivity().finish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242148);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderInvalidActivityUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class b extends IListener<ih> {
        final /* synthetic */ FinderInvalidActivityUIC tsb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderInvalidActivityUIC finderInvalidActivityUIC) {
            this.tsb = finderInvalidActivityUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            String str;
            String str2;
            FinderInvalidActivityUIC finderInvalidActivityUIC;
            ih.a aVar;
            LinearLayout linearLayout;
            ih.a aVar2;
            AppMethodBeat.i(242147);
            ih ihVar2 = ihVar;
            int i2 = (ihVar2 == null || (aVar2 = ihVar2.dMT) == null) ? -1 : aVar2.responseCode;
            Log.i("Finder.InvalidActivityUIC", "FinderTopicEvent : ".concat(String.valueOf(i2)));
            if (i2 == -4056 || i2 == -4058 || i2 == -4063) {
                FinderInvalidActivityUIC finderInvalidActivityUIC2 = this.tsb;
                if (ihVar2 == null || (aVar = ihVar2.dMT) == null) {
                    str = null;
                } else {
                    str = aVar.errMsg;
                }
                ViewStub viewStub = (ViewStub) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cji);
                if (viewStub != null) {
                    viewStub.inflate();
                }
                finderInvalidActivityUIC2.tmh = (LinearLayout) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjh);
                LinearLayout linearLayout2 = finderInvalidActivityUIC2.tmh;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView = (TextView) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjl);
                if (textView != null) {
                    ao.a(textView.getPaint(), 0.8f);
                }
                finderInvalidActivityUIC2.trX = (TextView) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjj);
                finderInvalidActivityUIC2.trY = (WeImageView) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjk);
                String string = finderInvalidActivityUIC2.getResources().getString(R.string.cgw);
                p.g(string, "resources.getString(R.st…_activity_invalid_detail)");
                int color = finderInvalidActivityUIC2.getResources().getColor(R.color.Blue_100);
                if (i2 == -4058) {
                    if (str == null) {
                        str = finderInvalidActivityUIC2.getResources().getString(R.string.chn);
                        p.g(str, "resources.getString(R.st…ctivity_violation_detail)");
                    }
                    color = finderInvalidActivityUIC2.getResources().getColor(R.color.Red_100);
                    str2 = str;
                } else {
                    if (i2 == -4063) {
                        string = finderInvalidActivityUIC2.getResources().getString(R.string.j9x);
                        p.g(string, "resources.getString(R.st…er_activity_feed_removed)");
                        TextView textView2 = (TextView) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjl);
                        if (textView2 != null) {
                            textView2.setText(string);
                        }
                        TextView textView3 = finderInvalidActivityUIC2.trX;
                        if (textView3 != null) {
                            textView3.setVisibility(4);
                            str2 = string;
                        }
                    }
                    str2 = string;
                }
                TextView textView4 = finderInvalidActivityUIC2.trX;
                if (textView4 != null) {
                    textView4.setText(str2);
                }
                WeImageView weImageView = finderInvalidActivityUIC2.trY;
                if (weImageView != null) {
                    weImageView.setIconColor(color);
                }
                Button button = (Button) finderInvalidActivityUIC2.getActivity().findViewById(R.id.cjg);
                if (button != null) {
                    button.setOnClickListener(new c(finderInvalidActivityUIC2));
                    finderInvalidActivityUIC = finderInvalidActivityUIC2;
                } else {
                    button = null;
                    finderInvalidActivityUIC = finderInvalidActivityUIC2;
                }
                finderInvalidActivityUIC.trW = button;
                FinderInvalidActivityUIC.a(this.tsb, i2);
            } else if (i2 == 0 && (linearLayout = this.tsb.tmh) != null) {
                linearLayout.setVisibility(8);
            }
            AppMethodBeat.o(242147);
            return true;
        }
    }

    public static final /* synthetic */ void a(FinderInvalidActivityUIC finderInvalidActivityUIC, int i2) {
        AppMethodBeat.i(242153);
        if (i2 == -4058) {
            hn hnVar = new hn();
            hnVar.dLW.id = finderInvalidActivityUIC.getIntent().getLongExtra("key_feed_ref_id", 0);
            hnVar.dLW.type = 13;
            EventCenter.instance.publish(hnVar);
        }
        AppMethodBeat.o(242153);
    }
}
