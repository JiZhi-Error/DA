package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.j;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView extends LinearLayout implements c.b {
    protected bp DEv = bp.Oqt;
    private double EpZ = 0.0d;
    private double Eqa = 0.0d;
    protected y Eqb;
    protected w.a Eqc;
    protected int Eqd;
    protected int Eqe;
    private boolean Eqf = false;
    private long Eqg = 0;
    private boolean Eqh = false;
    boolean Eqi = false;
    boolean Eqj = false;
    private String Eqk;
    private String Eql;
    private String Eqm;
    private String Eqn;
    private String Eqo;
    private String Eqp;
    private String Eqq;
    private String Eqr;
    private long Eqs;
    private int Eqt = 0;
    private boolean Equ = false;
    public int Eqv = 0;
    private b Eqw;
    private a Eqx = new a();
    private IListener Eqy = new IListener<np>() {
        /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass8 */

        {
            AppMethodBeat.i(203248);
            this.__eventId = np.class.getName().hashCode();
            AppMethodBeat.o(203248);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(np npVar) {
            AppMethodBeat.i(203249);
            np npVar2 = npVar;
            if (FlipView.this.Eqh) {
                if (npVar2 != null && (npVar2 instanceof np)) {
                    Log.i("MicroMsg.FlipView", "notify Event: %d", Integer.valueOf(npVar2.dTL.dTJ));
                    if (npVar2.dTL.activity == ((Activity) FlipView.this.context) && npVar2.dTL.dDX.equals(FlipView.this.Eqn)) {
                        switch (npVar2.dTL.dTJ) {
                            case 3:
                                ((Activity) FlipView.this.context).finish();
                                break;
                        }
                    } else {
                        Log.e("MicroMsg.FlipView", "not the same");
                    }
                } else {
                    Log.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
                }
            } else {
                Log.i("MicroMsg.FlipView", "no need to scan image");
            }
            AppMethodBeat.o(203249);
            return false;
        }
    };
    private Context context;
    private int dFL;
    private int dFM;
    protected MMHandler handler;
    private long hwQ = 0;
    protected int infoType = -1;
    private ScanCodeSheetItemLogic mHu;
    e oXS;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass7 */

        {
            AppMethodBeat.i(160695);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(160695);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(97877);
            qz qzVar2 = qzVar;
            if (!FlipView.this.Eqh) {
                Log.i("MicroMsg.FlipView", "no need to scan image");
                AppMethodBeat.o(97877);
            } else if (FlipView.this.oXS == null || FlipView.this.Eqk == null) {
                Log.e("MicroMsg.FlipView", "not in recoging");
                AppMethodBeat.o(97877);
            } else if (qzVar2 == null || !(qzVar2 instanceof qz)) {
                Log.e("MicroMsg.FlipView", "receive invalid callbak");
                AppMethodBeat.o(97877);
            } else if (!qzVar2.dXz.filePath.equals(FlipView.this.Eqk)) {
                Log.e("MicroMsg.FlipView", "not same filepath");
                AppMethodBeat.o(97877);
            } else {
                Log.i("MicroMsg.FlipView", "recog result: " + qzVar2.dXz.result);
                if (!Util.isNullOrNil(qzVar2.dXz.result)) {
                    FlipView.this.Eqn = qzVar2.dXz.result;
                    FlipView.this.dFL = qzVar2.dXz.dFL;
                    FlipView.this.dFM = qzVar2.dXz.dFM;
                    if (!(FlipView.this.Eqn == null || FlipView.this.oXS == null)) {
                        FlipView.this.Equ = true;
                        FlipView.c(FlipView.this, FlipView.this.Eqk);
                        FlipView.this.mHu.cm(FlipView.this.dFL, FlipView.this.Eqn);
                    }
                    FlipView.this.g(FlipView.this.Eqk, FlipView.this.Eql, FlipView.this.Eqm, false);
                }
                FlipView.this.Eqk = null;
                AppMethodBeat.o(97877);
            }
            return false;
        }
    };

    public interface b {
        void ffI();

        void ha(List<Integer> list);
    }

    public abstract boolean ffH();

    public abstract MMViewPager getGallery();

    public abstract int getPosition();

    public abstract String getSelectedMediaId();

    public abstract long getSnsId();

    class a implements Runnable {
        float x;
        float y;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(97879);
            AppMethodBeat.o(97879);
        }
    }

    private void ffG() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.Eqd = displayMetrics.widthPixels;
        this.Eqe = displayMetrics.heightPixels;
    }

    public FlipView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        init(context2);
    }

    public FlipView(Context context2) {
        super(context2);
        init(context2);
    }

    private void init(Context context2) {
        this.context = context2;
        this.handler = new MMHandler();
        ffG();
        EventCenter.instance.addListener(this.teF);
        EventCenter.instance.addListener(this.Eqy);
        this.mHu = new ScanCodeSheetItemLogic(context2);
    }

    public void setNeedScanImage(boolean z) {
        this.Eqh = z;
    }

    public void setNeedTranslationImg(boolean z) {
        this.Eqi = z;
    }

    public void setNeedOCRImg(boolean z) {
        this.Eqj = z;
    }

    public void setOnMenuShowListener(b bVar) {
        this.Eqw = bVar;
    }

    public View getCurrentImageView() {
        return null;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Log.d("MicroMsg.FlipView", "onTouchEvent down");
            this.EpZ = (double) motionEvent.getX();
            this.Eqa = (double) motionEvent.getY();
            this.hwQ = System.currentTimeMillis();
            if (f.ai(motionEvent) == 1) {
                this.Eqf = false;
            }
        }
        if (f.ai(motionEvent) > 1) {
            this.Eqf = true;
        }
        if (motionEvent.getAction() == 1 && !this.Eqf) {
            Log.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hwQ));
            long currentTicks = Util.currentTicks();
            Log.d("MicroMsg.FlipView", "deltTime: " + (currentTicks - this.Eqg));
            if (currentTicks - this.Eqg < 300) {
                this.handler.removeCallbacks(this.Eqx);
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(97871);
                        AppMethodBeat.o(97871);
                    }
                });
                return super.dispatchTouchEvent(motionEvent);
            }
            this.Eqg = currentTicks;
            if (System.currentTimeMillis() - this.hwQ < 500 && Math.abs(((double) motionEvent.getX()) - this.EpZ) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.Eqa) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.Eqe - 100))) {
                a aVar = this.Eqx;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.Eqx, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public void cj(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void g(final String str, final String str2, final String str3, boolean z) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        SnsInfo aQm = aj.faO().aQm(str2);
        if (aQm == null) {
            Log.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (aQm.getTypeFlag() != 21) {
            arrayList.add(this.context.getString(R.string.h9u));
            arrayList2.add(1);
            if (com.tencent.mm.br.c.aZU("favorite")) {
                arrayList.add(this.context.getString(R.string.fn9));
                arrayList2.add(2);
            }
            if (aQm.field_type == 15 || aQm.field_type == 5) {
                arrayList.add(this.context.getString(R.string.gav));
                arrayList2.add(0);
            } else if (aQm.field_type == 1) {
                arrayList.add(this.context.getString(R.string.gaq));
                arrayList2.add(0);
                if (this.Eqi) {
                    arrayList.add(this.context.getString(R.string.az0));
                    arrayList2.add(7);
                    ep epVar = new ep();
                    epVar.ejA = 2;
                    if (ffH()) {
                        epVar.eDV = 6;
                    } else {
                        epVar.eDV = 7;
                    }
                    cnb cntMedia = getCntMedia();
                    if (cntMedia != null) {
                        epVar.rK(cntMedia.Url);
                    }
                    epVar.bfK();
                }
                if (this.Eqj) {
                    arrayList.add(this.context.getString(R.string.ayy));
                    arrayList2.add(9);
                }
            } else {
                arrayList.add(this.context.getString(R.string.h_2));
                arrayList2.add(0);
            }
            ef efVar = new ef();
            efVar.dHy.dHp = str2;
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX) {
                arrayList.add(this.context.getString(R.string.xa));
                arrayList2.add(5);
            }
            if (!y.aQH(str2) && aQm.field_type == 1) {
                arrayList.add(this.context.getString(R.string.ayz));
                arrayList2.add(6);
            }
            if (this.Eqn != null) {
                arrayList.add("");
                arrayList2.add(4);
            }
            if (aQm.field_type == 1 && ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch() && r.Yn(this.Eqv)) {
                arrayList.add(this.context.getString(R.string.cf_));
                arrayList2.add(8);
                if (!this.Equ) {
                    ab abVar = new ab();
                    ab abVar2 = abVar.ie("").m7if(r.Jb(getSnsId()));
                    abVar2.enp = r.Yo(this.Eqv);
                    abVar2.eki = 1;
                    abVar2.enq = 81;
                    abVar.ig("");
                    abVar.ih("");
                    abVar.ii(com.tencent.mm.b.g.getMD5(str));
                    abVar.enx = System.currentTimeMillis();
                    abVar.bfK();
                    ar.a(abVar);
                }
            }
        } else if (!aQm.getUserName().equals(z.aTY())) {
            arrayList.add(this.context.getString(R.string.h6_));
            arrayList2.add(3);
        }
        if (this.oXS == null) {
            this.oXS = new e(this.context, 1, false);
        } else if (this.Equ) {
            this.Equ = false;
        }
        this.oXS.HLX = new o.f() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(97872);
                FlipView.this.oXS.setFooterView(null);
                mVar.clear();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((Integer) arrayList2.get(i2)).intValue() == 4) {
                        FlipView.this.oXS.setFooterView(FlipView.a(FlipView.this, str2, str3));
                    } else {
                        mVar.d(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                    }
                }
                AppMethodBeat.o(97872);
            }
        };
        this.oXS.PGl = new e.b() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(97873);
                if (FlipView.this.Eqw != null) {
                    FlipView.this.Eqw.ffI();
                }
                ax axVar = new ax();
                axVar.dDY.dDZ = FlipView.this.Eqs;
                axVar.dDY.filePath = FlipView.this.Eqk;
                EventCenter.instance.publish(axVar);
                FlipView.this.Eqp = null;
                FlipView.this.Eqo = null;
                FlipView.this.Eqr = null;
                FlipView.this.Eqq = null;
                FlipView.this.oXS = null;
                FlipView.this.Eqk = null;
                FlipView.this.Eql = "";
                FlipView.this.Eqm = null;
                FlipView.this.Eqn = null;
                FlipView.this.dFL = FlipView.this.dFM = 0;
                FlipView.this.Eqt = 0;
                FlipView.this.mHu.onDismiss();
                AppMethodBeat.o(97873);
            }
        };
        this.oXS.HLY = new o.g() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(97874);
                if (FlipView.this.Eqw != null) {
                    FlipView.this.Eqw.ffI();
                }
                SnsInfo aQm = aj.faO().aQm(str2);
                if (aQm == null) {
                    Log.i("MicroMsg.FlipView", "error beacause info null");
                    AppMethodBeat.o(97874);
                    return;
                }
                switch (menuItem.getItemId()) {
                    case 0:
                        if (aQm.field_type != 15) {
                            if (r.aBO(str) == 4) {
                                String str = s.k(str, false) + "_tmp";
                                s.boN(s.boZ(str));
                                ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(s.k(str, false), str);
                                com.tencent.mm.pluginsdk.ui.tools.s.l(str, FlipView.this.context);
                            } else {
                                com.tencent.mm.pluginsdk.ui.tools.s.l(str, FlipView.this.context);
                            }
                            FlipView.o(FlipView.this);
                            AppMethodBeat.o(97874);
                            return;
                        }
                        FlipView.aQO(str2);
                        AppMethodBeat.o(97874);
                        return;
                    case 1:
                        if (aQm.field_type != 15) {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            if (aQm != null) {
                                intent.putExtra("Retr_FromMainTimeline", FlipView.this.ffH());
                                intent.putExtra("Retr_KSnsId", r.v(aQm));
                            }
                            com.tencent.mm.plugin.sns.c.a.jRt.k(intent, FlipView.this.context);
                            AppMethodBeat.o(97874);
                            return;
                        }
                        new StringBuilder().append(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), str3)).append(r.e(aQm.getTimeLine().ContentObj.LoV.get(0)));
                        FlipView.aQP(str2);
                        AppMethodBeat.o(97874);
                        return;
                    case 2:
                        if (aQm.field_type != 15) {
                            cz czVar = new cz();
                            String str2 = str2;
                            String str3 = str3;
                            if (str3 == null || Util.isNullOrNil(str2)) {
                                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                                czVar.dFZ.dGe = R.string.c_2;
                            } else if (aj.isInValid()) {
                                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                                czVar.dFZ.dGe = R.string.c_j;
                            } else {
                                SnsInfo aQm2 = aj.faO().aQm(str2);
                                if (aQm2 == null) {
                                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                                    czVar.dFZ.dGe = R.string.c_3;
                                } else {
                                    com.tencent.mm.plugin.sns.l.a.a(czVar, aQm2, str3);
                                }
                            }
                            czVar.dFZ.dGf = 13;
                            czVar.dFZ.activity = (Activity) FlipView.this.context;
                            EventCenter.instance.publish(czVar);
                            if (FlipView.this.ffH()) {
                                vj vjVar = new vj();
                                vjVar.ebG.dRS = r.v(aQm);
                                vjVar.ebG.dHp = aQm.getLocalid();
                                EventCenter.instance.publish(vjVar);
                            }
                            AppMethodBeat.o(97874);
                            return;
                        } else if (aQm == null) {
                            AppMethodBeat.o(97874);
                            return;
                        } else {
                            if (!aQm.isAd()) {
                                FlipView.G(FlipView.this.ffH(), aQm.getLocalid());
                            } else {
                                cz czVar2 = new cz();
                                com.tencent.mm.plugin.sns.l.a.a(czVar2, aQm);
                                czVar2.dFZ.dGf = 14;
                                czVar2.dFZ.activity = (Activity) FlipView.this.context;
                                EventCenter.instance.publish(czVar2);
                            }
                            if (FlipView.this.ffH()) {
                                vj vjVar2 = new vj();
                                vjVar2.ebG.dRS = r.v(aQm);
                                vjVar2.ebG.dHp = aQm.getLocalid();
                                EventCenter.instance.publish(vjVar2);
                            }
                            AppMethodBeat.o(97874);
                            return;
                        }
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_expose_msg_id", FlipView.this.getSnsId());
                        SnsInfo JJ = aj.faO().JJ(FlipView.this.getSnsId());
                        intent2.putExtra("k_username", JJ == null ? "" : JJ.field_userName);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("rawUrl", e.C2115e.OyU + 33);
                        intent2.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                        com.tencent.mm.br.c.b(FlipView.this.context, "webview", ".ui.tools.WebViewUI", intent2);
                        AppMethodBeat.o(97874);
                        return;
                    case 5:
                        if (aQm.getTimeLine().ContentObj.LoV.size() == 0) {
                            AppMethodBeat.o(97874);
                            return;
                        }
                        Intent intent3 = new Intent();
                        if (aQm.field_type == 1) {
                            String i3 = FlipView.i(str, FlipView.this.context);
                            if (i3 == null) {
                                AppMethodBeat.o(97874);
                                return;
                            } else {
                                intent3.putExtra("sns_send_data_ui_image_path", i3);
                                intent3.putExtra("sns_send_data_ui_image_media_id", FlipView.this.getSelectedMediaId());
                            }
                        }
                        intent3.putExtra("sns_send_data_ui_activity", true);
                        intent3.putExtra("sns_local_id", str2);
                        com.tencent.mm.br.c.f(FlipView.this.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                        AppMethodBeat.o(97874);
                        return;
                    case 6:
                        FlipView.this.aQN(str);
                        AppMethodBeat.o(97874);
                        return;
                    case 7:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext())) {
                            wj wjVar = new wj();
                            wjVar.ecv.mediaId = str3;
                            EventCenter.instance.publish(wjVar);
                            ep epVar = new ep();
                            epVar.ejA = 3;
                            if (FlipView.this.ffH()) {
                                epVar.eDV = 6;
                            } else {
                                epVar.eDV = 7;
                            }
                            cnb cntMedia = FlipView.this.getCntMedia();
                            if (cntMedia != null) {
                                epVar.rK(cntMedia.Url);
                            }
                            epVar.bfK();
                            AppMethodBeat.o(97874);
                            return;
                        }
                        break;
                    case 8:
                        SnsInfo aQm3 = aj.faO().aQm(str2);
                        com.tencent.mm.plugin.websearch.api.o oVar = new com.tencent.mm.plugin.websearch.api.o();
                        oVar.context = FlipView.this.context;
                        oVar.dHq = str;
                        oVar.IDs = aQm3.field_userName;
                        oVar.dRS = r.Jb(FlipView.this.getSnsId());
                        oVar.dGf = r.Yo(FlipView.this.Eqv);
                        oVar.DIq = FlipView.this.getCntMedia();
                        ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
                        AppMethodBeat.o(97874);
                        return;
                    case 9:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext())) {
                            vw vwVar = new vw();
                            vwVar.ebW.mediaId = str3;
                            vwVar.ebW.dkU = aQm.getUserName();
                            EventCenter.instance.publish(vwVar);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(97874);
            }
        };
        this.oXS.dGm();
        if (this.Eqw != null) {
            this.Eqw.ha(arrayList2);
        }
        if (this.Eqh && true == z) {
            g.aAi();
            if (g.aAg().hqi.aYS() != 0) {
                this.Eqk = str;
                this.Eql = str2;
                this.Eqm = str3;
                qx qxVar = new qx();
                this.Eqs = System.currentTimeMillis();
                qxVar.dXu.dDZ = this.Eqs;
                qxVar.dXu.filePath = str;
                EventCenter.instance.publish(qxVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5 A[SYNTHETIC, Splitter:B:28:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd A[SYNTHETIC, Splitter:B:35:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d9 A[SYNTHETIC, Splitter:B:41:0x00d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(java.lang.String r12, android.content.Context r13) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.FlipView.i(java.lang.String, android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.Eqk = null;
        this.Eql = "";
        this.Eqm = null;
        if (this.Eqn != null) {
            aw awVar = new aw();
            awVar.dDW.activity = (Activity) this.context;
            awVar.dDW.dDX = this.Eqn;
            EventCenter.instance.publish(awVar);
            this.Eqn = null;
            this.dFM = 0;
            this.dFL = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventCenter.instance.removeListener(this.teF);
        EventCenter.instance.removeListener(this.Eqy);
        rl rlVar = new rl();
        rlVar.dYc.activity = (Activity) this.context;
        EventCenter.instance.publish(rlVar);
    }

    public cnb getCntMedia() {
        return null;
    }

    public final void F(cnb cnb) {
        if (cnb != null) {
            String ki = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), cnb.Id);
            String l = r.l(cnb);
            if (s.YS(ki + l)) {
                aQN(ki + l);
            }
        }
    }

    public final void aQN(String str) {
        if (s.YS(str)) {
            RecordConfigProvider jA = RecordConfigProvider.jA(str, "");
            if (this.DEv != null) {
                VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                videoCaptureReportInfo.sQn = -1;
                jA.BOE = videoCaptureReportInfo;
            }
            com.tencent.mm.plugin.recordvideo.jumper.a aVar = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, R.anim.ei, -1, jA, 1, 2);
        }
    }

    static /* synthetic */ View a(FlipView flipView, final String str, final String str2) {
        return flipView.mHu.a(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(203247);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/FlipView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FlipView", "request deal QBAR string");
                if (FlipView.this.oXS != null && FlipView.this.oXS.isShowing()) {
                    FlipView.this.oXS.bMo();
                }
                SnsInfo aQm = aj.faO().aQm(str);
                if (aQm == null) {
                    Log.i("MicroMsg.FlipView", "error beacause info null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/FlipView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203247);
                    return;
                }
                Log.i("MicroMsg.FlipView", "request deal QBAR string");
                cr crVar = new cr();
                crVar.dFK.activity = (Activity) FlipView.this.context;
                crVar.dFK.dDX = FlipView.this.Eqn;
                crVar.dFK.dFL = FlipView.this.dFL;
                crVar.dFK.dFM = FlipView.this.dFM;
                cnb a2 = an.a(aQm, str2);
                if (a2 != null) {
                    crVar.dFK.imagePath = a2.Url;
                    crVar.dFK.dFO = a2.MsO;
                }
                crVar.dFK.scene = 38;
                if (FlipView.this.context instanceof Activity) {
                    crVar.dFK.dFP = ((Activity) FlipView.this.context).getIntent().getBundleExtra("_stat_obj");
                }
                if (FlipView.this instanceof SnsInfoFlip) {
                    SnsInfoFlip snsInfoFlip = (SnsInfoFlip) FlipView.this;
                    bp fromScene = snsInfoFlip.getFromScene();
                    Log.d("MicroMsg.FlipView", "from Scene: %s", fromScene.tag);
                    if (fromScene.tag.equals(bp.Oqm.tag) || fromScene.tag.equals(bp.Oqn.tag) || fromScene.tag.equals(bp.Oqo.tag)) {
                        crVar.dFK.sourceType = 5;
                        if (Util.isNullOrNil(snsInfoFlip.username)) {
                            Log.i("MicroMsg.FlipView", "empty username");
                            snsInfoFlip.username = "";
                        }
                        crVar.dFK.source = snsInfoFlip.username;
                    } else if (fromScene.tag.equals(bp.Oql.tag)) {
                        crVar.dFK.sourceType = 3;
                    } else {
                        Log.i("MicroMsg.FlipView", "other scene_from: %s", fromScene.tag);
                    }
                }
                EventCenter.instance.publish(crVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/FlipView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203247);
            }
        }, flipView.dFL, flipView.Eqn, 6);
    }

    static /* synthetic */ void o(FlipView flipView) {
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass5 */

            public final void run() {
                String str;
                AppMethodBeat.i(203246);
                try {
                    cnb cntMedia = FlipView.this.getCntMedia();
                    SnsInfo JJ = aj.faO().JJ(FlipView.this.getSnsId());
                    if (JJ == null) {
                        Log.e("MicroMsg.FlipView", "[-] Fail to get snsInfo. snsId:%s", Long.valueOf(FlipView.this.getSnsId()));
                        AppMethodBeat.o(203246);
                        return;
                    }
                    String D = com.tencent.mm.plugin.sns.model.g.D(cntMedia);
                    if (D == null) {
                        Log.e("MicroMsg.FlipView", "[-] Fail to get path of media obj. snsLocalId:%s, snsId:%s, username:%s", JJ.getLocalid(), JJ.getSnsId(), JJ.getUserName());
                        AppMethodBeat.o(203246);
                        return;
                    }
                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(D);
                    if (imageOptions == null) {
                        Log.e("MicroMsg.FlipView", "[-] Fail to get bmp opts of media obj. snsLocalId:%s, snsId:%s, username:%s", JJ.getLocalid(), JJ.getSnsId(), JJ.getUserName());
                        AppMethodBeat.o(203246);
                        return;
                    }
                    String[] aIU = d.INSTANCE.aIU(D);
                    if (aIU != null) {
                        str = aIU[0];
                    } else {
                        str = "";
                    }
                    j.b c2 = j.c(j.a.dkQ);
                    c2.dkU = JJ.getUserName();
                    c2.msgId = JJ.field_snsId;
                    c2.dkW = cntMedia.Url;
                    c2.dkX = imageOptions.outWidth;
                    c2.dkY = imageOptions.outHeight;
                    c2.dkZ = cntMedia.Msz;
                    c2.md5 = com.tencent.mm.b.g.getMD5(D);
                    c2.dlb = str;
                    j.a(c2);
                    AppMethodBeat.o(203246);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.FlipView", th, "[-] Exception was thrown when report.", new Object[0]);
                    AppMethodBeat.o(203246);
                }
            }
        }, "SnsImgExportReport");
    }

    static /* synthetic */ void aQO(String str) {
        wn wnVar = new wn();
        wnVar.ecy.dKy = 3;
        wnVar.ecy.dJX = str;
        EventCenter.instance.publish(wnVar);
    }

    static /* synthetic */ void aQP(String str) {
        wn wnVar = new wn();
        wnVar.ecy.dKy = 1;
        wnVar.ecy.ecB = 2;
        wnVar.ecy.dJX = str;
        EventCenter.instance.publish(wnVar);
    }

    static /* synthetic */ void G(boolean z, String str) {
        wn wnVar = new wn();
        wnVar.ecy.dKy = 2;
        wnVar.ecy.ecz = 14;
        wnVar.ecy.ecA = z;
        wnVar.ecy.dJX = str;
        EventCenter.instance.publish(wnVar);
    }

    static /* synthetic */ void c(FlipView flipView, final String str) {
        ScanCodeSheetItemLogic scanCodeSheetItemLogic = flipView.mHu;
        int i2 = flipView.dFL;
        String str2 = flipView.Eqn;
        AnonymousClass9 r3 = new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.sns.ui.FlipView.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(203250);
                if (FlipView.this.oXS != null && FlipView.this.oXS.isShowing()) {
                    FlipView.this.Equ = true;
                    FlipView.this.g(str, FlipView.this.Eql, FlipView.this.Eqm, false);
                }
                AppMethodBeat.o(203250);
            }
        };
        scanCodeSheetItemLogic.CAh = null;
        if (!Util.isNullOrNil(str2)) {
            if (scanCodeSheetItemLogic.CAl == null) {
                scanCodeSheetItemLogic.CAl = new com.tencent.mm.plugin.scanner.d();
            }
            if (com.tencent.mm.plugin.scanner.g.ci(i2, str2)) {
                scanCodeSheetItemLogic.CAl.bZ(i2, str2).a(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: INVOKE  
                      (wrap: com.tencent.mm.vending.g.e<com.tencent.mm.protocal.protobuf.bws> : 0x0027: INVOKE  (r1v1 com.tencent.mm.vending.g.e<com.tencent.mm.protocal.protobuf.bws>) = 
                      (wrap: com.tencent.mm.plugin.scanner.d : 0x0025: IGET  (r4v4 com.tencent.mm.plugin.scanner.d) = (r0v0 'scanCodeSheetItemLogic' com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic) com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.CAl com.tencent.mm.plugin.scanner.d)
                      (r1v0 'i2' int)
                      (r2v0 'str2' java.lang.String)
                     type: VIRTUAL call: com.tencent.mm.plugin.scanner.d.bZ(int, java.lang.String):com.tencent.mm.vending.g.e)
                      (wrap: com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$1 : 0x002d: CONSTRUCTOR  (r4v5 com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$1) = 
                      (r0v0 'scanCodeSheetItemLogic' com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic)
                      (r2v0 'str2' java.lang.String)
                      (r3v0 'r3' com.tencent.mm.plugin.sns.ui.FlipView$9)
                     call: com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.1.<init>(com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic, java.lang.String, com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$a):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.vending.g.e.a(com.tencent.mm.vending.g.d$b):com.tencent.mm.vending.g.d in method: com.tencent.mm.plugin.sns.ui.FlipView.c(com.tencent.mm.plugin.sns.ui.FlipView, java.lang.String):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: CONSTRUCTOR  (r4v5 com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$1) = 
                      (r0v0 'scanCodeSheetItemLogic' com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic)
                      (r2v0 'str2' java.lang.String)
                      (r3v0 'r3' com.tencent.mm.plugin.sns.ui.FlipView$9)
                     call: com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.1.<init>(com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic, java.lang.String, com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.FlipView.c(com.tencent.mm.plugin.sns.ui.FlipView, java.lang.String):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                    com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic r0 = r5.mHu
                    int r1 = r5.dFL
                    java.lang.String r2 = r5.Eqn
                    com.tencent.mm.plugin.sns.ui.FlipView$9 r3 = new com.tencent.mm.plugin.sns.ui.FlipView$9
                    r3.<init>(r6)
                    r4 = 0
                    r0.CAh = r4
                    boolean r4 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2)
                    if (r4 != 0) goto L_0x0033
                    com.tencent.mm.plugin.scanner.d r4 = r0.CAl
                    if (r4 != 0) goto L_0x001f
                    com.tencent.mm.plugin.scanner.d r4 = new com.tencent.mm.plugin.scanner.d
                    r4.<init>()
                    r0.CAl = r4
                L_0x001f:
                    boolean r4 = com.tencent.mm.plugin.scanner.g.ci(r1, r2)
                    if (r4 == 0) goto L_0x0033
                    com.tencent.mm.plugin.scanner.d r4 = r0.CAl
                    com.tencent.mm.vending.g.e r1 = r4.bZ(r1, r2)
                    com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$1 r4 = new com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic$1
                    r4.<init>(r2, r3)
                    r1.a(r4)
                L_0x0033:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.FlipView.c(com.tencent.mm.plugin.sns.ui.FlipView, java.lang.String):void");
            }
        }
