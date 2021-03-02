package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected h BHV;
    private View BHW;
    private IListener<ha> BHX = new IListener<ha>() {
        /* class com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161426);
            this.__eventId = ha.class.getName().hashCode();
            AppMethodBeat.o(161426);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ha haVar) {
            AppMethodBeat.i(27871);
            ha haVar2 = haVar;
            int firstVisiblePosition = RecordMsgBaseUI.this.krb.getFirstVisiblePosition();
            int lastVisiblePosition = RecordMsgBaseUI.this.krb.getLastVisiblePosition();
            int max = Math.max(firstVisiblePosition, 0);
            int max2 = Math.max(lastVisiblePosition, 0);
            if (max < 0 || max2 >= RecordMsgBaseUI.this.krb.getAdapter().getCount()) {
                Log.i("MicroMsg.RecordMsgBaseUI", "invalid position %d-%d, cnt:%d", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(RecordMsgBaseUI.this.krb.getAdapter().getCount()));
                AppMethodBeat.o(27871);
                return false;
            }
            for (int i2 = max; i2 <= max2; i2++) {
                aml aml = (aml) RecordMsgBaseUI.this.krb.getAdapter().getItem(i2);
                if (aml != null && Util.isEqual(aml.dLl, haVar2.dLj.dLl)) {
                    View childAt = RecordMsgBaseUI.this.krb.getChildAt(i2);
                    if (childAt == null) {
                        Log.e("MicroMsg.RecordMsgBaseUI", "[getPhotoInfo] getChildAt(%d)", Integer.valueOf(i2));
                    } else {
                        View findViewById = childAt.findViewById(R.id.gx4);
                        if (findViewById != null) {
                            int[] iArr = new int[2];
                            findViewById.getLocationInWindow(iArr);
                            haVar2.dLk.dEq = iArr[0];
                            haVar2.dLk.dEr = iArr[1];
                            haVar2.dLk.dEs = findViewById.getWidth();
                            haVar2.dLk.dEt = findViewById.getHeight();
                        }
                    }
                }
            }
            AppMethodBeat.o(27871);
            return true;
        }
    };
    protected String appId = "";
    protected ListView krb = null;
    protected long msgId = -1;

    /* access modifiers changed from: protected */
    public abstract h eIt();

    /* access modifiers changed from: protected */
    public abstract String eIu();

    /* access modifiers changed from: protected */
    public abstract String eIv();

    /* access modifiers changed from: protected */
    public abstract String eIw();

    /* access modifiers changed from: protected */
    public abstract void eIx();

    /* access modifiers changed from: protected */
    public abstract void f(int i2, int i3, Intent intent);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.blt;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        h.q(this);
        super.onCreate(bundle);
        eIs();
        this.BHX.alive();
        h.r(this);
    }

    /* access modifiers changed from: protected */
    public void eIs() {
        String str;
        g gVar;
        String str2;
        g gVar2;
        this.BHV = eIt();
        this.msgId = getIntent().getLongExtra("message_id", -1);
        this.appId = getIntent().getStringExtra("record_app_id");
        this.krb = (ListView) findViewById(R.id.gxc);
        eIA();
        String eIv = eIv();
        String eIw = eIw();
        if (Util.isNullOrNil(eIv) || Util.isNullOrNil(eIw)) {
            Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            String str3 = eIv.split(" ")[0];
            String str4 = eIw.split(" ")[0];
            if (!eIv.split("-")[0].equals(eIw.split("-")[0])) {
                this.BHV.BHN = true;
                str3 = null;
            } else if (str3.equals(str4)) {
                this.BHV.BHO = false;
            } else {
                str3 = str3 + "~" + str4;
                this.BHV.BHO = true;
            }
            setMMSubTitle(str3);
        }
        View inflate = View.inflate(getContext(), R.layout.bls, null);
        TextView textView = (TextView) inflate.findViewById(R.id.ir1);
        String eIv2 = eIv();
        String eIw2 = eIw();
        if (Util.isNullOrNil(eIv2) || Util.isNullOrNil(eIw2)) {
            Log.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            String aLb = aLb(eIv2.split(" ")[0]);
            String aLb2 = aLb(eIw2.split(" ")[0]);
            if (!aLb.equals(aLb2)) {
                aLb = aLb + " " + getString(R.string.how) + " " + aLb2;
            }
            textView.setText(aLb);
        }
        this.krb.addHeaderView(inflate, null, false);
        View inflate2 = View.inflate(getContext(), R.layout.blr, null);
        if (Util.isNullOrNil(this.appId)) {
            bg.aVF();
            ca Hb = c.aSQ().Hb(this.msgId);
            k.b aD = k.b.aD(Hb.field_content, Hb.field_reserved);
            if (aD != null) {
                this.appId = aD.appId;
                gVar2 = com.tencent.mm.pluginsdk.model.app.h.gE(this.appId, aD.appVersion);
                str2 = (gVar2 == null || gVar2.field_appName == null || gVar2.field_appName.trim().length() <= 0) ? aD.appName : gVar2.field_appName;
            } else {
                str2 = null;
                gVar2 = null;
            }
            str = str2;
            gVar = gVar2;
        } else {
            g o = com.tencent.mm.pluginsdk.model.app.h.o(this.appId, true, false);
            str = (o == null || o.field_appName == null || o.field_appName.trim().length() <= 0) ? "" : o.field_appName;
            gVar = o;
        }
        if (!Util.isNullOrNil(this.appId) && gVar != null) {
            this.BHW = inflate2.findViewById(R.id.g4s);
            this.BHW.setVisibility(0);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.uf);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.ug);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int textSize = (int) (((double) textView2.getTextSize()) * 1.5d);
            layoutParams.height = textSize;
            layoutParams.width = textSize;
            imageView.setLayoutParams(layoutParams);
            textView2.setText(getResources().getString(R.string.fjd, com.tencent.mm.pluginsdk.model.app.h.a(getContext(), gVar, str)));
            Bitmap c2 = com.tencent.mm.pluginsdk.model.app.h.c(this.appId, 1, a.getDensity(getContext()));
            if (c2 == null || c2.isRecycled()) {
                b(imageView, BitmapFactory.decodeResource(getResources(), R.drawable.bjq));
            } else {
                b(imageView, c2);
            }
        }
        this.krb.addFooterView(inflate2, null, false);
        this.krb.setAdapter((ListAdapter) this.BHV);
        this.BHV.mListView = this.krb;
        this.BHV.eIy();
        this.BHV.BHS = getIntent().getIntExtra("preChatTYPE", 0);
        this.krb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(27872);
                if (i2 == 0) {
                    yh yhVar = new yh();
                    yhVar.eeC.type = 5;
                    yhVar.eeC.eeD = RecordMsgBaseUI.this.krb.getFirstVisiblePosition();
                    yhVar.eeC.eeE = RecordMsgBaseUI.this.krb.getLastVisiblePosition();
                    yhVar.eeC.eeF = RecordMsgBaseUI.this.krb.getHeaderViewsCount();
                    EventCenter.instance.publish(yhVar);
                }
                AppMethodBeat.o(27872);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                int i5 = 0;
                AppMethodBeat.i(27873);
                if (i2 == 0) {
                    View childAt = RecordMsgBaseUI.this.krb.getChildAt(0);
                    if (childAt != null) {
                        i5 = childAt.getTop();
                    }
                    if (i5 == 0) {
                        RecordMsgBaseUI.this.hideActionbarLine();
                        AppMethodBeat.o(27873);
                        return;
                    }
                }
                RecordMsgBaseUI.this.showActionbarLine();
                AppMethodBeat.o(27873);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27874);
                RecordMsgBaseUI.this.finish();
                AppMethodBeat.o(27874);
                return true;
            }
        });
        eIx();
        this.krb.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(27875);
                View childAt = RecordMsgBaseUI.this.krb.getChildAt(RecordMsgBaseUI.this.krb.getLastVisiblePosition());
                if (!(childAt == null || RecordMsgBaseUI.this.BHW == null || RecordMsgBaseUI.this.BHW.getVisibility() != 0)) {
                    int bottom = childAt.getBottom();
                    int bottom2 = RecordMsgBaseUI.this.krb.getBottom();
                    Log.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", Integer.valueOf(bottom), Integer.valueOf(bottom2));
                    int fromDPToPix = a.fromDPToPix((Context) RecordMsgBaseUI.this.getContext(), 64);
                    if (bottom2 - bottom > 0) {
                        int fromDPToPix2 = (bottom2 - bottom) + a.fromDPToPix((Context) RecordMsgBaseUI.this.getContext(), 15);
                        Log.d("MicroMsg.RecordMsgBaseUI", "offset %d", Integer.valueOf(fromDPToPix2));
                        if (fromDPToPix2 > fromDPToPix) {
                            RecordMsgBaseUI.this.BHW.setPadding(0, fromDPToPix2, 0, 0);
                        }
                    }
                }
                AppMethodBeat.o(27875);
            }
        }, 100);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        yh yhVar = new yh();
        if (this.krb != null) {
            yhVar.eeC.type = 0;
            yhVar.eeC.eeD = this.krb.getFirstVisiblePosition();
            yhVar.eeC.eeE = this.krb.getLastVisiblePosition();
            yhVar.eeC.eeF = this.krb.getHeaderViewsCount();
            EventCenter.instance.publish(yhVar);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (this.BHV != null) {
            h hVar = this.BHV;
            for (int i2 = 0; i2 < hVar.BHM.size(); i2++) {
                h.b valueAt = hVar.BHM.valueAt(i2);
                if (valueAt != null) {
                    valueAt.pause();
                }
            }
        }
        yh yhVar = new yh();
        yhVar.eeC.type = 1;
        EventCenter.instance.publish(yhVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.BHX.dead();
        if (this.BHV != null) {
            this.BHV.destroy();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        f(i2, i3, intent);
    }

    private String aLb(String str) {
        try {
            return (String) DateFormat.format(getContext().getString(R.string.dev), new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime());
        } catch (ParseException e2) {
            return str;
        }
    }

    private void b(ImageView imageView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) getResources().getDimension(R.dimen.kc);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    /* access modifiers changed from: protected */
    public final void eIA() {
        String eIu = eIu();
        String string = getContext().getString(R.string.c35);
        if (eIu != null && eIu.endsWith(string) && eIu.lastIndexOf(string) > 0) {
            eIu = eIu.substring(0, eIu.lastIndexOf(string) - 1);
        }
        setMMTitle(l.e((Context) getContext(), (CharSequence) eIu, getResources().getDimensionPixelSize(R.dimen.l)));
    }
}
