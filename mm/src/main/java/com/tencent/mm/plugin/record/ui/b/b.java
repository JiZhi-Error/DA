package com.tencent.mm.plugin.record.ui.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.i;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class b implements h.b {
    public String BHK;
    public String BHL;
    private h.a BHR;
    boolean BJb = false;
    private e.a BJc = new e.a();
    MMHandler handler;
    View.OnClickListener ko = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.record.ui.b.b.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:14:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00fb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r15) {
            /*
            // Method dump skipped, instructions count: 4220
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.ui.b.b.AnonymousClass1.onClick(android.view.View):void");
        }
    };
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.record.ui.b.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161430);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(161430);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(28017);
            mx mxVar2 = mxVar;
            if (mxVar2 instanceof mx) {
                switch (mxVar2.dSE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
                        break;
                }
            }
            AppMethodBeat.o(28017);
            return false;
        }
    };
    private int tlc = 0;
    private View.OnClickListener tls = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.record.ui.b.b.AnonymousClass2 */

        public final void onClick(View view) {
            String z;
            css css;
            String str;
            AppMethodBeat.i(28016);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!com.tencent.mm.compatible.util.e.apn()) {
                u.g(view.getContext(), null);
                a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28016);
                return;
            }
            com.tencent.mm.plugin.record.ui.a.b bVar2 = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            if (b.f(bVar2.dKT)) {
                Log.i("MicroMsg.OtherViewWrapper", "same song, do release");
                ol olVar = new ol();
                olVar.enl = 2;
                olVar.erW = 16;
                aq.a(olVar);
                com.tencent.mm.ay.a.bea();
                if (!b.this.BJb) {
                    b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
                }
            } else {
                b.this.BJb = true;
                amn amn = bVar2.dKT.Lwh.LwO;
                o oVar = new o(p.f(bVar2.dKT, bVar2.msgId));
                if (oVar.exists()) {
                    z = aa.z(oVar.her());
                } else if (bVar2.dKT.dFN == null) {
                    z = "";
                } else {
                    StringBuilder sb = new StringBuilder();
                    bg.aVF();
                    o oVar2 = new o(sb.append(c.aTi()).append("web/").append(g.getMessageDigest(bVar2.dKT.dFN.getBytes())).toString());
                    if (oVar2.exists()) {
                        str = aa.z(oVar2.her());
                    } else {
                        str = "";
                    }
                    z = str;
                }
                aml aml = bVar2.dKT;
                if (aml.Lwh != null) {
                    css = aml.Lwh.Lxs;
                } else {
                    css = null;
                }
                String str2 = aml.title;
                String str3 = aml.desc;
                String str4 = aml.Lvu;
                String str5 = aml.Lvy;
                String str6 = aml.Lvw;
                String str7 = aml.dLl;
                StringBuilder sb2 = new StringBuilder();
                bg.aVF();
                f a2 = i.a(6, null, str2, str3, str4, str5, str6, str7, sb2.append(c.aTi()).append("web/").toString(), z, "", amn.appId, com.tencent.mm.ay.h.a(aml.dLl, css));
                a2.jfm = aml.songAlbumUrl;
                a2.jfe = aml.songLyric;
                a2.jfw = aml.dLl;
                com.tencent.mm.ay.a.c(a2);
                ol olVar2 = new ol();
                olVar2.enl = 1;
                olVar2.erW = 16;
                aq.a(olVar2);
            }
            a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28016);
        }
    };

    public b(h.a aVar, MMHandler mMHandler) {
        AppMethodBeat.i(28018);
        this.BHR = aVar;
        this.handler = mMHandler;
        AppMethodBeat.o(28018);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final View createView(Context context) {
        AppMethodBeat.i(28019);
        View inflate = View.inflate(context, R.layout.blm, null);
        this.tlc = com.tencent.mm.cb.a.fromDPToPix(context, 75);
        EventCenter.instance.addListener(this.lEl);
        AppMethodBeat.o(28019);
        return inflate;
    }

    public static boolean f(aml aml) {
        AppMethodBeat.i(28021);
        f bef = com.tencent.mm.ay.a.bef();
        if (bef == null || bef.jeT != 6 || !Util.nullAs(aml.dLl, "").equals(bef.jeV) || !com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(28021);
            return false;
        }
        AppMethodBeat.o(28021);
        return true;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    @SuppressLint({"ResourceType"})
    public final void a(View view, int i2, com.tencent.mm.plugin.record.ui.a.b bVar, Object obj) {
        String str;
        String string;
        AppMethodBeat.i(28022);
        TextView textView = (TextView) view.findViewById(R.id.ipm);
        TextView textView2 = (TextView) view.findViewById(R.id.bmr);
        TextView textView3 = (TextView) view.findViewById(R.id.i2x);
        MMImageView mMImageView = (MMImageView) view.findViewById(R.id.dt5);
        View findViewById = view.findViewById(R.id.gwz);
        mMImageView.setVisibility(0);
        findViewById.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.id.du2);
        imageView.setVisibility(8);
        View findViewById2 = view.findViewById(R.id.gx4);
        findViewById2.setVisibility(0);
        findViewById2.setTag(bVar);
        findViewById2.setOnClickListener(this.ko);
        View findViewById3 = view.findViewById(R.id.j0a);
        findViewById3.setVisibility(8);
        h.a.C1632a aVar = new h.a.C1632a();
        if (bVar.dataType == 0) {
            aVar.BHU = bVar.msgId;
        } else if (bVar.dataType == 1) {
            aVar.BHU = bVar.qNT.field_localId;
        }
        aVar.dKU = mMImageView;
        aVar.dKT = bVar.dKT;
        aVar.height = this.tlc;
        aVar.width = this.tlc;
        switch (bVar.dKT.dataType) {
            case 4:
            case 15:
                aml aml = bVar.dKT;
                if (Util.isNullOrNil(aml.title)) {
                    textView.setText(R.string.cd1);
                } else {
                    textView.setText(aml.title);
                }
                if (aml.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    Context context = textView2.getContext();
                    int i3 = aml.duration;
                    if (i3 <= 0) {
                        string = context.getString(R.string.cd3, 0);
                    } else {
                        int i4 = i3 / 60;
                        int i5 = i3 % 60;
                        if (i4 == 0) {
                            string = context.getString(R.string.cd3, Integer.valueOf(i5));
                        } else {
                            string = context.getString(R.string.cd2, Integer.valueOf(i4), Integer.valueOf(i5));
                        }
                    }
                    textView2.setText(string);
                }
                if (aml.Lwh == null) {
                    Log.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", aml.dLl);
                    textView3.setVisibility(8);
                } else {
                    amn amn = aml.Lwh.LwO;
                    if (!Util.isNullOrNil(amn.appId)) {
                        String appName = getAppName(textView3.getContext(), amn.appId);
                        if (Util.isNullOrNil(appName)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(appName);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.raw.shortvideo_play_btn);
                aVar.dKV = R.raw.app_attach_file_icon_video;
                this.BHR.a(aVar);
                break;
            case 5:
                aml aml2 = bVar.dKT;
                String str2 = "";
                anq anq = null;
                if (!(aml2 == null || aml2.Lwh == null)) {
                    anq = aml2.Lwh.LwS;
                }
                if (anq != null) {
                    str2 = anq.title;
                }
                if (Util.isNullOrNil(str2) && aml2 != null) {
                    str2 = aml2.title;
                }
                if (Util.isNullOrNil(str2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str2);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                String str3 = "";
                if (anq != null) {
                    str3 = Util.getHost(anq.LyC);
                }
                amn amn2 = null;
                if (!(aml2 == null || aml2.Lwh == null)) {
                    amn2 = aml2.Lwh.LwO;
                }
                if (amn2 != null) {
                    if (!Util.isNullOrNil(amn2.appId)) {
                        str3 = Util.nullAs(getAppName(textView3.getContext(), amn2.appId), "");
                    } else if (!Util.isNullOrNil(amn2.dCl)) {
                        bg.aVF();
                        as Kn = c.aSN().Kn(amn2.dCl);
                        if (Kn == null || !Kn.field_username.equals(amn2.dCl)) {
                            ay.a.iDq.a(amn2.dCl, "", null);
                        } else {
                            str3 = Kn.arJ();
                        }
                    }
                    if (Util.isNullOrNil(str3) || str3.equals(amn2.dCl)) {
                        str3 = Util.getHost(amn2.link);
                    }
                }
                if (Util.isNullOrNil(str3)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(str3);
                    textView3.setVisibility(0);
                }
                aVar.dKV = R.drawable.bxc;
                this.BHR.a(aVar);
                if (!(bVar.dKT == null || bVar.dKT.Lwh == null || bVar.dKT.Lwh.IXu == null || bVar.dKT.Lwh.IXu.iwc != 5)) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.raw.shortvideo_play_btn);
                    break;
                }
                break;
            case 6:
                aml aml3 = bVar.dKT;
                if (aml3.Lwh == null) {
                    Log.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", aml3.dLl);
                    textView.setText(R.string.ca4);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ams ams = aml3.Lwh.LwQ;
                    if (Util.isNullOrNil(ams.dWi)) {
                        textView.setText(ams.label);
                        textView2.setText(R.string.ca4);
                        textView3.setText("");
                    } else {
                        textView.setText(ams.dWi);
                        textView2.setText(ams.label);
                        textView3.setText(R.string.ca4);
                    }
                }
                mMImageView.setImageResource(R.raw.app_attach_file_icon_location);
                break;
            case 7:
            case 29:
                textView.setText(bVar.dKT.title);
                textView2.setText(bVar.dKT.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.tls);
                imageView.setImageResource(R.drawable.am5);
                imageView.setVisibility(0);
                if (f(bVar.dKT)) {
                    imageView.setImageResource(R.drawable.alq);
                }
                textView3.setVisibility(8);
                aVar.dKV = R.raw.app_attach_file_icon_music;
                this.BHR.a(aVar);
                break;
            case 8:
                aml aml4 = bVar.dKT;
                textView.setText(aml4.title);
                textView2.setVisibility(0);
                textView2.setText(Util.getLengthStr((float) aml4.LvI));
                textView3.setVisibility(8);
                if (aml4.Lwv == 2) {
                    textView2.setText(">" + ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(false) + "MB");
                }
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.f.bcX(bVar.dKT.LvC));
                break;
            case 9:
            case 12:
            case 13:
            case 18:
            case 20:
            case 21:
            case 24:
            case 25:
            default:
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(0);
                AppMethodBeat.o(28022);
                return;
            case 10:
                aml aml5 = bVar.dKT;
                if (aml5.Lwh == null) {
                    Log.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", aml5.dLl);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ana ana = aml5.Lwh.LwU;
                    textView.setText(ana.title);
                    textView2.setText(ana.desc);
                    textView3.setText(Util.nullAs(getAppName(textView3.getContext(), aml5.Lwh.LwO.appId), textView3.getContext().getString(R.string.cax)));
                }
                aVar.dKV = R.raw.app_attach_file_icon_unknow;
                this.BHR.a(aVar);
                break;
            case 11:
                aml aml6 = bVar.dKT;
                if (aml6.Lwh == null) {
                    Log.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", aml6.dLl);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ana ana2 = aml6.Lwh.LwU;
                    textView.setText(ana2.title);
                    textView2.setText(ana2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.dKV = R.raw.app_attach_file_icon_unknow;
                aVar.dKT = null;
                this.BHR.a(aVar);
                break;
            case 14:
                aml aml7 = bVar.dKT;
                if (aml7.Lwh == null || aml7.Lwh.LwW == null) {
                    Log.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", aml7.dLl);
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ank ank = aml7.Lwh.LwW;
                    textView.setText(ank.title);
                    textView2.setText(ank.desc);
                    textView3.setText(Util.nullAs(getAppName(textView3.getContext(), aml7.Lwh.LwO.appId), textView3.getContext().getString(R.string.ccx)));
                }
                aVar.dKV = R.raw.app_attach_file_icon_unknow;
                aVar.dKT = null;
                this.BHR.a(aVar);
                break;
            case 16:
                aml aml8 = bVar.dKT;
                bg.aVF();
                ca.a aEK = c.aSQ().aEK(aml8.desc);
                if (aEK == null) {
                    Log.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                Context context2 = textView.getContext();
                if (aEK != null) {
                    str = aEK.nickname;
                } else {
                    str = "";
                }
                textView.setText(l.b(context2, str, textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(R.string.c_n);
                textView3.setVisibility(0);
                String str4 = aEK.dkU;
                if (!Util.isNullOrNil(str4)) {
                    a.b.c(mMImageView, str4);
                    break;
                } else {
                    mMImageView.setImageResource(R.drawable.bca);
                    break;
                }
            case 17:
                aml aml9 = bVar.dKT;
                textView.setText(aml9.title);
                textView2.setVisibility(0);
                textView2.setText(aml9.desc);
                mMImageView.setVisibility(8);
                findViewById.setVisibility(8);
                break;
            case 19:
                aml aml10 = bVar.dKT;
                int i6 = bVar.dKT.dataType;
                String str5 = "";
                if (aml10 != null) {
                    str5 = aml10.title;
                }
                if (Util.isNullOrNil(str5)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str5);
                    textView.setVisibility(0);
                }
                String str6 = "";
                if (19 == i6) {
                    str6 = textView2.getContext().getString(R.string.ko);
                }
                if (Util.isNullOrNil(str6)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str6);
                    textView2.setVisibility(0);
                }
                h.a.c cVar = new h.a.c();
                cVar.dKT = bVar.dKT;
                if (bVar.dataType == 0) {
                    cVar.BHU = bVar.msgId;
                } else if (bVar.dataType == 1) {
                    cVar.BHU = bVar.qNT.field_localId;
                }
                aVar.dKV = R.drawable.bxc;
                Bitmap a2 = this.BHR.a(cVar);
                if (a2 == null) {
                    this.BHR.a(aVar);
                    break;
                } else {
                    mMImageView.setImageBitmap(a2);
                    break;
                }
            case 22:
                if (!com.tencent.mm.plugin.fav.a.b.cUq()) {
                    aml aml11 = bVar.dKT;
                    if (!(aml11.Lwh == null || aml11.Lwh.Lxk == null)) {
                        bcj bcj = aml11.Lwh.Lxk;
                        textView.setText(Util.nullAsNil(bcj.nickname + MMApplicationContext.getContext().getString(R.string.cce)));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        if (!Util.isNullOrNil(bcj.mediaList)) {
                            com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                            com.tencent.mm.loader.a aJs = com.tencent.mm.loader.e.aJs();
                            String str7 = bcj.mediaList.get(0).thumbUrl;
                            e.a aVar2 = this.BJc;
                            aVar2.hZJ = true;
                            aVar2.hZI = true;
                            aJs.a(str7, (ImageView) mMImageView, aVar2.aJT());
                        }
                    }
                    imageView.setVisibility(8);
                    break;
                } else {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                    break;
                }
            case 23:
                if (!com.tencent.mm.plugin.fav.a.b.cUq()) {
                    aml aml12 = bVar.dKT;
                    if (!(aml12.Lwh == null || aml12.Lwh.Lxm == null)) {
                        axf axf = aml12.Lwh.Lxm;
                        textView.setText(Util.nullAsNil(axf.nickName + MMApplicationContext.getContext().getString(R.string.ccd)));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        if (!Util.isNullOrNil(axf.coverUrl)) {
                            com.tencent.mm.loader.e eVar2 = com.tencent.mm.loader.e.hXU;
                            com.tencent.mm.loader.a aJs2 = com.tencent.mm.loader.e.aJs();
                            String str8 = axf.coverUrl;
                            e.a aVar3 = this.BJc;
                            aVar3.hZJ = true;
                            aVar3.hZI = true;
                            aJs2.a(str8, (ImageView) mMImageView, aVar3.aJT());
                        }
                    }
                    imageView.setVisibility(8);
                    break;
                } else {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                    break;
                }
            case 27:
                if (com.tencent.mm.plugin.fav.a.b.cUq()) {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                } else {
                    aml aml13 = bVar.dKT;
                    if (!(aml13.Lwh == null || aml13.Lwh.Lxu == null)) {
                        bcl bcl = aml13.Lwh.Lxu;
                        textView.setText(Util.nullAsNil(aml13.title));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        if (!Util.isNullOrNil(bcl.iconUrl)) {
                            com.tencent.mm.loader.e eVar3 = com.tencent.mm.loader.e.hXU;
                            com.tencent.mm.loader.a aJs3 = com.tencent.mm.loader.e.aJs();
                            String str9 = bcl.iconUrl;
                            e.a aVar4 = this.BJc;
                            aVar4.hZJ = true;
                            aVar4.hZI = true;
                            aJs3.a(str9, (ImageView) mMImageView, aVar4.aJT());
                        }
                    }
                    imageView.setVisibility(8);
                }
            case 26:
                if (!com.tencent.mm.plugin.fav.a.b.cUq()) {
                    aml aml14 = bVar.dKT;
                    if (!(aml14.Lwh == null || aml14.Lwh.Lxo == null)) {
                        bci bci = aml14.Lwh.Lxo;
                        textView.setText(Util.nullAsNil(aml14.title));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        if (!Util.isNullOrNil(bci.uNR)) {
                            com.tencent.mm.loader.e eVar4 = com.tencent.mm.loader.e.hXU;
                            com.tencent.mm.loader.a aJs4 = com.tencent.mm.loader.e.aJs();
                            String str10 = bci.uNR;
                            e.a aVar5 = this.BJc;
                            aVar5.hZJ = true;
                            aVar5.hZI = true;
                            aJs4.a(str10, (ImageView) mMImageView, aVar5.aJT());
                        }
                    }
                    imageView.setVisibility(8);
                    break;
                } else {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                    break;
                }
            case 28:
                if (!com.tencent.mm.plugin.fav.a.b.cUq()) {
                    aml aml15 = bVar.dKT;
                    if (!(aml15.Lwh == null || aml15.Lwh.Lxq == null)) {
                        bcf bcf = aml15.Lwh.Lxq;
                        textView.setText(Util.nullAsNil(aml15.title));
                        textView.setVisibility(0);
                        textView2.setVisibility(8);
                        if (!Util.isNullOrNil(bcf.LLt)) {
                            StringBuilder sb = new StringBuilder(bcf.LLt.getFirst());
                            if (!Util.isNullOrNil(bcf.LLu)) {
                                sb.append(bcf.LLu.getFirst());
                            }
                            com.tencent.mm.loader.e eVar5 = com.tencent.mm.loader.e.hXU;
                            com.tencent.mm.loader.a aJs5 = com.tencent.mm.loader.e.aJs();
                            String sb2 = sb.toString();
                            e.a aVar6 = this.BJc;
                            aVar6.hZJ = true;
                            aVar6.hZI = true;
                            aJs5.a(sb2, (ImageView) mMImageView, aVar6.aJT());
                        }
                    }
                    imageView.setVisibility(8);
                    break;
                } else {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(0);
                    break;
                }
        }
        textView3.setVisibility(8);
        AppMethodBeat.o(28022);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void destroy() {
        AppMethodBeat.i(28023);
        Log.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.BHR = null;
        this.handler = null;
        EventCenter.instance.removeListener(this.lEl);
        this.BJb = false;
        AppMethodBeat.o(28023);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void pause() {
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2) {
        AppMethodBeat.i(28024);
        a(intent, bVar, context, str, str2, true);
        AppMethodBeat.o(28024);
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(28025);
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", bVar.dKT.duration);
        intent.putExtra("key_detail_statExtStr", bVar.dKT.ean);
        intent.putExtra("key_detail_is_data_exist", z);
        intent.putExtra("key_detail_msg_uuid", bVar.dKT.jsz);
        com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        AppMethodBeat.o(28025);
    }

    static void am(Context context, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(28026);
        if ((context instanceof Activity) && (intent2 = ((Activity) context).getIntent()) != null) {
            intent.putExtra("prePublishId", intent2.getStringExtra("prePublishId"));
            intent.putExtra("preUsername", intent2.getStringExtra("preUsername"));
            intent.putExtra("preChatName", intent2.getStringExtra("preChatName"));
            intent.putExtra("preChatTYPE", intent2.getIntExtra("preChatTYPE", 0));
        }
        AppMethodBeat.o(28026);
    }

    private static String getAppName(Context context, String str) {
        AppMethodBeat.i(28020);
        am.b bVar = am.a.iDo;
        if (bVar != null) {
            String r = bVar.r(context, str);
            AppMethodBeat.o(28020);
            return r;
        }
        AppMethodBeat.o(28020);
        return "";
    }

    static /* synthetic */ void a(View view, amm amm) {
        amt amt;
        AppMethodBeat.i(28027);
        if (view != null && ((amm.IXu != null && amm.IXu.iwc >= 0) || amm.Lxi != null)) {
            int[] iArr = new int[2];
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                view.getLocationInWindow(iArr);
                if (amm.IXu != null) {
                    amt = amm.IXu;
                } else {
                    amt = amm.Lxi;
                }
                if (amt != null) {
                    amt.LxS = new amu();
                    amt.LxS.left = iArr[0];
                    amt.LxS.top = iArr[1];
                    amt.LxS.width = width;
                    amt.LxS.height = height;
                }
            }
        }
        AppMethodBeat.o(28027);
    }

    static /* synthetic */ void a(b bVar, Context context, com.tencent.mm.plugin.record.ui.a.b bVar2) {
        String z;
        css css;
        String str;
        AppMethodBeat.i(232052);
        if (bVar2.dKT == null && bVar2.qNT == null) {
            Log.e("MicroMsg.OtherViewWrapper", "No valid data, null == recordData.dataItem && null == recordData.favItemInfo");
            AppMethodBeat.o(232052);
            return;
        }
        if (((aj) com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast()) {
            String str2 = "";
            if (!(bVar2.qNT == null || bVar2.qNT.field_favProto == null || bVar2.qNT.field_favProto.Lya == null)) {
                str2 = bVar2.qNT.field_favProto.Lya.appId;
            }
            if (bVar2.dKT != null) {
                aml aml = bVar2.dKT;
                o oVar = new o(com.tencent.mm.plugin.fav.a.b.a(aml));
                if (oVar.exists()) {
                    z = aa.z(oVar.her());
                } else if (aml.dFN == null) {
                    z = "";
                } else {
                    o oVar2 = new o(com.tencent.mm.plugin.fav.a.b.cUf() + g.getMessageDigest(aml.dFN.getBytes()));
                    if (oVar2.exists()) {
                        str = aa.z(oVar2.her());
                    } else {
                        str = "";
                    }
                    z = str;
                }
                if (aml == null || aml.Lwh == null) {
                    css = null;
                } else {
                    css = aml.Lwh.Lxs;
                }
                f a2 = i.a(6, null, aml.title, aml.desc, aml.Lvu, aml.Lvy, aml.Lvw, aml.dLl, com.tencent.mm.plugin.fav.a.b.cUl(), z, "", str2, com.tencent.mm.ay.h.a(aml.dLl, css));
                a2.jfm = aml.songAlbumUrl;
                a2.jfe = aml.songLyric;
                a2.jfw = aml.dLl;
                if (!com.tencent.mm.plugin.fav.a.b.f(aml)) {
                    Log.i("MicroMsg.OtherViewWrapper", " start play music");
                    com.tencent.mm.ay.a.c(a2);
                }
                Intent intent = new Intent();
                intent.putExtra("key_scene", 6);
                if (!(bVar2 == null || bVar2.dKT == null || bVar2.dKT.Lwh == null)) {
                    css css2 = bVar2.dKT.Lwh.Lxs;
                    if (css2 != null) {
                        intent.putExtra("key_mv_song_name", bVar2.dKT.title);
                        intent.putExtra("key_mv_song_lyric", bVar2.dKT.songLyric);
                        intent.putExtra("key_mv_album_cover_url", bVar2.dKT.songAlbumUrl);
                        intent.putExtra("key_mv_feed_id", css2.Ktn);
                        intent.putExtra("key_mv_nonce_id", css2.Kto);
                        intent.putExtra("key_mv_cover_url", css2.Ktp);
                        intent.putExtra("key_mv_poster", css2.Ktq);
                        intent.putExtra("key_mv_singer_name", css2.singerName);
                        intent.putExtra("key_mv_album_name", css2.albumName);
                        intent.putExtra("key_mv_music_genre", css2.musicGenre);
                        intent.putExtra("key_mv_issue_date", String.valueOf(css2.issueDate));
                        intent.putExtra("key_mv_identification", css2.identification);
                        intent.putExtra("key_mv_extra_info", css2.extraInfo);
                        intent.putExtra("key_mv_music_duration", css2.Alz);
                    }
                    if (css2 != null && Util.isNullOrNil(css2.singerName)) {
                        intent.putExtra("key_mv_singer_name", aml.desc);
                    }
                }
                intent.setFlags(268435456);
                SecDataUIC.a aVar = SecDataUIC.CWq;
                cst cst = (cst) SecDataUIC.a.a(context, "MusicMvMainUI", 7, cst.class);
                cst.scene = 2;
                com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                cst.MxI = 84;
                cst.MxJ = bVar.BHK;
                com.tencent.mm.br.c.b(context, "mv", ".ui.MusicMvMainUI", intent);
            }
        }
        AppMethodBeat.o(232052);
    }

    static /* synthetic */ void a(Context context, com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(232053);
        Intent intent = new Intent();
        if (Util.isNullOrNil(bVar.dKT.Lvu)) {
            Log.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", bVar.dKT.dLl);
            intent.putExtra("rawUrl", bVar.dKT.Lvw);
        } else {
            intent.putExtra("rawUrl", bVar.dKT.Lvu);
        }
        if (bVar.dataType == 1) {
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", bVar.qNT.field_localId);
            intent.putExtra("key_detail_can_delete", false);
            Bundle PV = com.tencent.mm.modelstat.a.c.PV(com.tencent.mm.pluginsdk.model.g.class.getName());
            PV.putInt("mm_rpt_fav_id", bVar.qNT.field_id);
            intent.putExtra("mm_report_bundle", PV);
            Log.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", Integer.valueOf(bVar.qNT.field_id), Long.valueOf(bVar.qNT.field_localId), bVar.dKT.dLl);
        }
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(232053);
    }
}
