package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.c;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.b.d.i;

public class aq implements ad {
    private int DPi = 1;
    private int EpG;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    private WXMediaMessage Erq = null;
    private String EsT;
    private boolean EsU = false;
    b EuF = new b();
    z EuG;
    Map<String, Exif.a> EuH = new HashMap();
    private Map<String, eas> EuI = new HashMap();
    private int EuJ = 0;
    private boolean EuK = false;
    cjy EuL;
    private String appId;
    private String appName;
    protected MMActivity gte;
    private String mSessionId;

    static /* synthetic */ void a(aq aqVar, bf bfVar) {
        AppMethodBeat.i(259452);
        aqVar.a(bfVar);
        AppMethodBeat.o(259452);
    }

    public aq(MMActivity mMActivity) {
        AppMethodBeat.i(98173);
        this.gte = mMActivity;
        AppMethodBeat.o(98173);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public void aC(Bundle bundle) {
        String str;
        String string;
        int i2;
        Exif.a location;
        Exif.a location2;
        AppMethodBeat.i(98174);
        this.EpM = k.w(this.gte.getIntent());
        this.EsU = this.gte.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.EuK = this.gte.getIntent().getBooleanExtra("KBlockAdd", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
        this.EsT = this.gte.getIntent().getStringExtra("KSessionID");
        Bundle bundleExtra = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.Erq = new SendMessageToWX.Req(bundleExtra).message;
        }
        String stringExtra = this.gte.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.gte.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.Erq != null && this.Erq.mediaObject != null && (this.Erq.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.Erq.mediaObject).imageData;
        }
        if (!Util.isNullOrNil(stringExtra) || Util.isNullOrNil(byteArrayExtra)) {
            str = stringExtra;
        } else {
            String str2 = aj.getAccSnsTmpPath() + g.getMessageDigest((" " + System.currentTimeMillis()).getBytes());
            s.deleteFile(str2);
            s.f(str2, byteArrayExtra, byteArrayExtra.length);
            str = str2;
        }
        int intExtra = this.gte.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            string = null;
        } else {
            string = bundle.getString("sns_kemdia_path_list");
        }
        aE(bundle);
        boolean aE = aE(this.gte.getIntent().getExtras());
        this.EuJ = 0;
        if (!Util.isNullOrNil(string)) {
            this.EuF.aQY(string);
        } else {
            ArrayList<String> stringArrayListExtra = this.gte.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (!Util.isNullOrNil(stringArrayListExtra)) {
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Log.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(next)));
                    this.EuF.t(next, intExtra, false);
                    if (!aE && (location2 = Exif.fromFile(next).getLocation()) != null) {
                        this.EuH.put(next, location2);
                    }
                    try {
                        o oVar = new o(next);
                        eas eas = new eas();
                        eas.Nam = this.EsU ? 1 : 2;
                        eas.Nao = oVar.lastModified() / 1000;
                        eas.Nan = Exif.fromFile(next).getUxtimeDatatimeOriginal();
                        this.EuI.put(next, eas);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
                    }
                }
            } else if (!Util.isNullOrNil(str)) {
                String str3 = aj.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.getMessageDigest(str.getBytes());
                s.boN(s.boZ(str3));
                s.nw(str, str3);
                if (intExtra == -1) {
                    i2 = 0;
                } else {
                    i2 = intExtra;
                }
                this.EuF.t(str3, i2, this.EsU);
                if (!aE && (location = Exif.fromFile(str).getLocation()) != null) {
                    this.EuH.put(str3, location);
                }
                try {
                    o oVar2 = new o(str);
                    eas eas2 = new eas();
                    eas2.Nam = this.EsU ? 1 : 2;
                    eas2.Nao = oVar2.lastModified() / 1000;
                    eas2.Nan = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                    this.EuI.put(str3, eas2);
                } catch (Exception e3) {
                    Log.e("MicroMsg.PicWidget", "get report info error " + e3.getMessage());
                }
            }
        }
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(98174);
    }

    public final int fgG() {
        AppMethodBeat.i(98175);
        int size = this.EuF.EuQ.size();
        AppMethodBeat.o(98175);
        return size;
    }

    private boolean aE(Bundle bundle) {
        AppMethodBeat.i(98176);
        if (bundle == null) {
            AppMethodBeat.o(98176);
            return false;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            AppMethodBeat.o(98176);
            return false;
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split("\n");
            if (3 != split.length) {
                Log.e("MicroMsg.PicWidget", "invalid params");
                AppMethodBeat.o(98176);
                return true;
            }
            try {
                this.EuH.put(split[0].trim(), new Exif.a(Util.getDouble(split[1], 0.0d), Util.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.PicWidget", e2.toString());
            }
        }
        AppMethodBeat.o(98176);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
        AppMethodBeat.i(98177);
        bundle.putString("sns_kemdia_path_list", this.EuF.toString());
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Exif.a> entry : this.EuH.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", entry.getKey(), Double.valueOf(entry.getValue().latitude), Double.valueOf(entry.getValue().longitude)));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
        AppMethodBeat.o(98177);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        boolean z;
        AppMethodBeat.i(98178);
        if (this.EuF != null) {
            b bVar = this.EuF;
            if (bVar.EuQ == null || bVar.EuQ.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(98178);
                return true;
            }
        }
        AppMethodBeat.o(98178);
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        boolean z;
        AppMethodBeat.i(98179);
        if (this.EuG == null) {
            MMActivity mMActivity = this.gte;
            ArrayList<String> arrayList = this.EuF.EuQ;
            AnonymousClass1 r7 = new z.a() {
                /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ui.z.a
                public final void Lc(int i2) {
                    AppMethodBeat.i(98155);
                    Log.d("MicroMsg.PicWidget", "I click");
                    if (i2 < 0) {
                        aq.this.fgH();
                        AppMethodBeat.o(98155);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(aq.this.gte, SnsUploadBrowseUI.class);
                    intent.putExtra("sns_gallery_position", i2);
                    intent.putExtra("sns_gallery_temp_paths", aq.this.EuF.EuQ);
                    intent.putExtra("key_from_scene", 7);
                    aq.this.gte.startActivityForResult(intent, 7);
                    AppMethodBeat.o(98155);
                }
            };
            AnonymousClass2 r8 = new c.a() {
                /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.ui.previewimageview.c.a
                public final void iK(int i2, int i3) {
                    AppMethodBeat.i(98156);
                    b bVar = aq.this.EuF;
                    if (i2 != i3 && bVar.EuQ.size() > i2) {
                        String remove = bVar.EuQ.remove(i2);
                        if (i3 < bVar.EuQ.size()) {
                            bVar.EuQ.add(i3, remove);
                        } else {
                            bVar.EuQ.add(remove);
                        }
                    }
                    aq.this.gte.getIntent().putExtra("sns_kemdia_path_list", aq.this.EuF.EuQ);
                    AppMethodBeat.o(98156);
                }

                @Override // com.tencent.mm.plugin.sns.ui.previewimageview.c.a
                public final void removeItem(int i2) {
                    AppMethodBeat.i(98157);
                    b bVar = aq.this.EuF;
                    if (bVar.EuQ.size() > i2) {
                        bVar.EuQ.remove(i2);
                    }
                    if (aq.this.gte instanceof SnsUploadUI) {
                        ((SnsUploadUI) aq.this.gte).fjN();
                    }
                    aq.this.gte.getIntent().putExtra("sns_kemdia_path_list", aq.this.EuF.EuQ);
                    aq.this.gte.getIntent().putExtra("sns_kemdia_path", "");
                    ((e) aq.this.EuG).aah(aq.this.EuF.EuQ.size());
                    AppMethodBeat.o(98157);
                }
            };
            if (!this.EuK) {
                z = true;
            } else {
                z = false;
            }
            this.EuG = new e(view, view2, view3, mMActivity, arrayList, dynamicGridView, r7, r8, z);
        } else {
            this.EuG.setList$22875ea3(this.EuF.EuQ);
        }
        View view4 = this.EuG.getView();
        AppMethodBeat.o(98179);
        return view4;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public View ffB() {
        AppMethodBeat.i(98180);
        this.EuG = new PreviewImageView(this.gte);
        if (this.EuK) {
            this.EuG.setIsShowAddImage(false);
        }
        this.EuG.setImageClick(new z.a() {
            /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sns.ui.z.a
            public final void Lc(int i2) {
                AppMethodBeat.i(98158);
                Log.d("MicroMsg.PicWidget", "I click");
                if (i2 < 0) {
                    aq.this.fgH();
                    AppMethodBeat.o(98158);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(aq.this.gte, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i2);
                intent.putExtra("key_from_scene", 7);
                intent.putExtra("sns_gallery_temp_paths", aq.this.EuF.EuQ);
                aq.this.gte.startActivityForResult(intent, 7);
                AppMethodBeat.o(98158);
            }
        });
        this.EuG.setList$22875ea3(this.EuF.EuQ);
        View view = this.EuG.getView();
        AppMethodBeat.o(98180);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    class a extends h<String, Integer, Boolean> {
        private bf Eth;
        private List<q> EuN;
        private ProgressDialog gtM = null;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(98166);
            super.onPostExecute(bool);
            this.gtM.dismiss();
            aq.a(aq.this, this.Eth);
            AppMethodBeat.o(98166);
        }

        public a(bf bfVar, List<q> list) {
            AppMethodBeat.i(98164);
            this.Eth = bfVar;
            this.EuN = list;
            MMActivity mMActivity = aq.this.gte;
            aq.this.gte.getString(R.string.zb);
            this.gtM = com.tencent.mm.ui.base.h.a((Context) mMActivity, aq.this.gte.getString(R.string.wd), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(aq.this) {
                /* class com.tencent.mm.plugin.sns.ui.aq.a.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(98164);
        }

        @Override // com.tencent.mm.plugin.sns.model.h
        public final ExecutorService eGk() {
            AppMethodBeat.i(179157);
            ExecutorService faB = aj.faB();
            AppMethodBeat.o(179157);
            return faB;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(259450);
            long currentTimeMillis = System.currentTimeMillis();
            bf bfVar = this.Eth;
            bfVar.gS(this.EuN);
            this.Eth = bfVar;
            Log.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(259450);
            return bool;
        }
    }

    private static bf a(bf bfVar, List<q> list) {
        AppMethodBeat.i(98181);
        bfVar.gS(list);
        AppMethodBeat.o(98181);
        return bfVar;
    }

    private void a(bf bfVar) {
        AppMethodBeat.i(98182);
        int commit = bfVar.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            com.tencent.mm.plugin.sns.k.g.DVR.c(this.EpM);
        }
        if (!(this.EuF == null || this.EuF.EuQ == null || !r.fff())) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12834, Integer.valueOf(this.EuF.EuQ.size()));
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.gte.setResult(-1, intent);
        this.gte.finish();
        aj.faK().eZn();
        AppMethodBeat.o(98182);
    }

    /* access modifiers changed from: protected */
    public void b(bf bfVar) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        eas eas;
        int i7;
        boolean z2;
        AppMethodBeat.i(98183);
        LinkedList<q> linkedList2 = new LinkedList();
        Iterator<String> it = this.EuF.EuQ.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            String next = it.next();
            q qVar = new q(next, 2);
            qVar.type = 2;
            qVar.DEB = i2;
            if (i8 == 0) {
                qVar.DEA = i3;
                if (iVar != null) {
                    qVar.DEC = iVar.token;
                    qVar.DED = iVar.Mte;
                }
            } else {
                qVar.DEA = 0;
            }
            int i9 = i8 + 1;
            b bVar = this.EuF;
            if (bVar.EuS.containsKey(next)) {
                i7 = bVar.EuS.get(next).intValue();
            } else {
                i7 = 0;
            }
            qVar.DEz = i7;
            qVar.desc = str;
            b bVar2 = this.EuF;
            if (Util.isNullOrNil(next) || !bVar2.EuR.containsKey(next)) {
                z2 = false;
            } else {
                z2 = bVar2.EuR.get(next).booleanValue();
            }
            qVar.DEF = z2;
            linkedList2.add(qVar);
            i8 = i9;
        }
        LinkedList<ebm> linkedList3 = new LinkedList<>();
        if (list != null) {
            new LinkedList();
            List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
            for (String str3 : list) {
                if (!gnq.contains(str3)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str3;
                    linkedList3.add(ebm);
                }
            }
        }
        bf bfVar = new bf(1, this.gte);
        pInt.value = bfVar.beK;
        if (iVar != null) {
            bfVar.kl(iVar.token, iVar.Mte);
        }
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            bfVar.YF(3);
        }
        bfVar.aPw(str).a(cjy).bq(linkedList3).YI(i2).YJ(i3);
        if (z) {
            bfVar.YL(1);
        } else {
            bfVar.YL(0);
        }
        if (!Util.isNullOrNil(this.appId)) {
            bfVar.aPC(this.appId);
        }
        if (!Util.isNullOrNil(this.appName)) {
            bfVar.aPD(Util.nullAs(this.appName, ""));
        }
        bfVar.YK(this.EpG);
        if (this.Ero) {
            bfVar.YK(5);
        }
        if (this.Erp && this.Erq != null) {
            bfVar.aPx(this.Erq.mediaTagName);
            bfVar.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
        }
        bfVar.g(null, null, null, i5, i6);
        bfVar.ct(this.DPi, this.EpN);
        bfVar.gR(list2);
        bfVar.setSessionId(this.mSessionId);
        b(bfVar);
        if (!(cjy == null || cjy.score == 0)) {
            int i10 = cjy.score;
            String str4 = cjy.LIb;
            bfVar.DPe.Mtm = new dzk();
            bfVar.DPe.Mtm.MZf = i10;
            bfVar.DPe.Mtm.MZd = str4;
        }
        Log.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", Integer.valueOf(linkedList2.size()), Integer.valueOf(this.EuJ));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11602, Integer.valueOf(this.EuJ), Integer.valueOf(linkedList2.size()));
        for (q qVar2 : linkedList2) {
            Log.i("MicroMsg.PicWidget", "commit path  %s len: %d", qVar2.path, Long.valueOf(s.boW(qVar2.path)));
        }
        for (q qVar3 : linkedList2) {
            String str5 = qVar3.path;
            eas eas2 = this.EuI.get(str5);
            if (eas2 == null) {
                eas = new eas();
            } else {
                eas = eas2;
            }
            if (this.EuL == null || (this.EuL.LbD == 0.0f && this.EuL.LbC == 0.0f)) {
                eas.Nak = -1000.0f;
                eas.Nal = -1000.0f;
            } else {
                eas.Nak = this.EuL.LbD;
                eas.Nal = this.EuL.LbC;
                eas.Esd = this.EuL.Esd;
                eas.cjn = this.EuL.cjn;
            }
            Exif.a aVar = this.EuH.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                eas.Nai = -1000.0f;
                eas.Naj = -1000.0f;
            } else {
                eas.Nai = (float) aVar.latitude;
                eas.Naj = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + bfVar.DPe.Mth.size());
            stringBuffer.append("||item poi lat " + eas.Nak + " " + eas.Nal);
            stringBuffer.append("||item pic lat " + eas.Nai + " " + eas.Naj);
            stringBuffer.append("||item exitime:" + eas.Nan + " filetime: " + eas.Nao);
            stringBuffer.append("||item source: " + eas.Nam);
            Log.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            bfVar.DPe.Mth.add(eas);
        }
        if (linkedList2.size() <= 1) {
            a(bfVar, linkedList2);
            a(bfVar);
        } else {
            new a(bfVar, linkedList2).y("");
        }
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass4 */

            public final void run() {
                int i2;
                AppMethodBeat.i(98159);
                long currentTimeMillis = System.currentTimeMillis();
                for (String str : aq.this.EuF.EuQ) {
                    Exif fromFile = Exif.fromFile(str);
                    int i3 = (fromFile.latitude < 0.0d || fromFile.longitude < 0.0d) ? 0 : 1;
                    String str2 = fromFile.model;
                    int i4 = fromFile.imageWidth;
                    int i5 = fromFile.imageHeight;
                    if (i4 <= 0 || i5 <= 0) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapUtil.decodeFile(str, options);
                        int i6 = options.outWidth;
                        i2 = options.outHeight;
                        i4 = i6;
                    } else {
                        i2 = i5;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15523, Integer.valueOf(i3), str2, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf((int) fromFile.getUxtimeDatatimeOriginal()));
                }
                Log.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(98159);
            }
        });
        AppMethodBeat.o(98183);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean fgH() {
        AppMethodBeat.i(98184);
        com.tencent.mm.kernel.g.aAi();
        if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
            u.g(this.gte, null);
            AppMethodBeat.o(98184);
            return false;
        } else if (this.EuF.EuQ.size() >= 9) {
            com.tencent.mm.ui.base.h.n(this.gte, R.string.hc0, R.string.zb);
            AppMethodBeat.o(98184);
            return false;
        } else {
            try {
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.gte, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(98160);
                        if (!ac.jPB) {
                            mVar.d(0, aq.this.gte.getString(R.string.um));
                        }
                        mVar.d(1, aq.this.gte.getString(R.string.uv));
                        AppMethodBeat.o(98160);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass6 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        boolean z;
                        boolean z2 = true;
                        AppMethodBeat.i(98161);
                        switch (menuItem.getItemId()) {
                            case 0:
                                aq.this.fjU();
                                AppMethodBeat.o(98161);
                                return;
                            case 1:
                                int size = 9 - aq.this.EuF.EuQ.size();
                                if (size > 0) {
                                    String string = aq.this.gte.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("gallery", "1");
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 2, 2, com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(cl.aWz()));
                                    if (string.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        com.tencent.mm.pluginsdk.ui.tools.s.aY(aq.this.gte);
                                    } else if (size < 9) {
                                        Intent intent = new Intent();
                                        intent.putExtra("key_can_select_video_and_pic", true);
                                        com.tencent.mm.pluginsdk.ui.tools.s.a(aq.this.gte, 9, size, 4, 1, intent);
                                    } else {
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.e.baZ().bbc().duration);
                                        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_enable_vlog, false);
                                        if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a2) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            z2 = false;
                                        }
                                        intent2.putExtra("key_can_select_video_and_pic", z2);
                                        com.tencent.mm.pluginsdk.ui.tools.s.a(aq.this.gte, 9, size, 4, 3, intent2);
                                    }
                                    aq.this.Zy(2);
                                    break;
                                } else {
                                    Log.e("MicroMsg.PicWidget", "has select the max image count");
                                    AppMethodBeat.o(98161);
                                    return;
                                }
                        }
                        AppMethodBeat.o(98161);
                    }
                };
                eVar.dGm();
            } catch (Exception e2) {
            }
            AppMethodBeat.o(98184);
            return true;
        }
    }

    public final boolean c(List<String> list, int i2, boolean z) {
        AppMethodBeat.i(98185);
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.PicWidget", "no image selected");
            AppMethodBeat.o(98185);
            return true;
        } else if (this.EuF.EuQ.size() >= 9) {
            AppMethodBeat.o(98185);
            return true;
        } else {
            for (String str : list) {
                if (s.YS(str)) {
                    String str2 = "pre_temp_sns_pic" + g.getMessageDigest((str + System.currentTimeMillis()).getBytes());
                    r.aR(aj.getAccSnsTmpPath(), str, str2);
                    com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.aLF(str);
                    Log.d("MicroMsg.PicWidget", "newPath " + aj.getAccSnsTmpPath() + str2);
                    this.EuF.t(aj.getAccSnsTmpPath() + str2, i2, z);
                    ((e) this.EuG).aah(this.EuF.EuQ.size());
                    this.EuG.setList$22875ea3(this.EuF.EuQ);
                    this.gte.getIntent().putExtra("sns_kemdia_path_list", this.EuF.EuQ);
                    try {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
                        eas eas = new eas();
                        eas.Nam = z ? 1 : 2;
                        eas.Nao = oVar.lastModified() / 1000;
                        eas.Nan = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.EuI.put(aj.getAccSnsTmpPath() + str2, eas);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
                    }
                    Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.EuH.put(aj.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
            AppMethodBeat.o(98185);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public boolean k(int i2, Intent intent) {
        String bhK;
        String stringExtra;
        AppMethodBeat.i(98186);
        switch (i2) {
            case 2:
                Log.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    AppMethodBeat.o(98186);
                    return false;
                }
                Log.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.jRt.a(this.gte, intent, intent2, aj.getAccSnsTmpPath(), 4, new a.AbstractC2129a() {
                    /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass7 */

                    @Override // com.tencent.mm.ui.tools.a.AbstractC2129a
                    public final String aQX(String str) {
                        AppMethodBeat.i(98162);
                        String str2 = aj.getAccSnsTmpPath() + g.getMessageDigest((str + System.currentTimeMillis()).getBytes());
                        AppMethodBeat.o(98162);
                        return str2;
                    }
                });
                AppMethodBeat.o(98186);
                return true;
            case 3:
                Log.d("MicroMsg.PicWidget", "onActivityResult 2");
                String h2 = com.tencent.mm.pluginsdk.ui.tools.s.h(this.gte.getApplicationContext(), intent, aj.getAccSnsTmpPath());
                if (h2 == null) {
                    AppMethodBeat.o(98186);
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", h2);
                String messageDigest = g.getMessageDigest((h2 + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", aj.getAccSnsTmpPath() + messageDigest);
                Exif.a location = Exif.fromFile(h2).getLocation();
                if (location != null) {
                    this.EuH.put(aj.getAccSnsTmpPath() + messageDigest, location);
                    Log.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", Double.valueOf(location.latitude), Double.valueOf(location.longitude));
                }
                eas eas = new eas();
                eas.Nam = 1;
                eas.Nao = System.currentTimeMillis();
                eas.Nan = Util.safeParseLong(Exif.fromFile(h2).dateTime);
                this.EuI.put(aj.getAccSnsTmpPath() + messageDigest, eas);
                com.tencent.mm.plugin.sns.c.a.jRt.a(this.gte, intent3, 4);
                this.EsU = true;
                AppMethodBeat.o(98186);
                return true;
            case 4:
                Log.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    AppMethodBeat.o(98186);
                    return true;
                }
                String stringExtra2 = intent.getStringExtra("CropImage_OutputPath");
                Log.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath ".concat(String.valueOf(stringExtra2)));
                if (stringExtra2 == null) {
                    AppMethodBeat.o(98186);
                    return true;
                } else if (!s.YS(stringExtra2)) {
                    AppMethodBeat.o(98186);
                    return true;
                } else if (this.EuF.EuQ.size() >= 9) {
                    AppMethodBeat.o(98186);
                    return true;
                } else {
                    int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                    String str = "pre_temp_sns_pic" + g.getMessageDigest((stringExtra2 + System.currentTimeMillis()).getBytes());
                    Log.i("MicroMsg.PicWidget", "onactivity result " + s.boW(stringExtra2) + " " + stringExtra2);
                    s.nw(stringExtra2, aj.getAccSnsTmpPath() + str);
                    if (this.EuH.containsKey(stringExtra2)) {
                        this.EuH.put(aj.getAccSnsTmpPath() + str, this.EuH.get(stringExtra2));
                    }
                    String str2 = aj.getAccSnsTmpPath() + str;
                    Log.d("MicroMsg.PicWidget", "newPath ".concat(String.valueOf(str2)));
                    this.EuF.t(str2, intExtra, false);
                    this.gte.getIntent().putExtra("sns_kemdia_path_list", this.EuF.EuQ);
                    ((e) this.EuG).aah(this.EuF.EuQ.size());
                    this.EuG.setList$22875ea3(this.EuF.EuQ);
                    AppMethodBeat.o(98186);
                    return true;
                }
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(98186);
                    return true;
                }
                this.EuF.aQ(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.gte.getIntent().putExtra("sns_kemdia_path_list", this.EuF.EuQ);
                ((e) this.EuG).aah(this.EuF.EuQ.size());
                this.EuG.setList$22875ea3(this.EuF.EuQ);
                this.EuJ = intent.getIntExtra("sns_update_preview_image_count", 0);
                AppMethodBeat.o(98186);
                return true;
            case 9:
                Bundle bundleExtra = intent.getBundleExtra("key_extra_data");
                if (bundleExtra == null || bundleExtra.getByteArray("key_bg_generate_pb") == null || bundleExtra.getByteArray("key_bg_generate_extra_config") == null) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && Util.isNullOrNil(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        int intExtra2 = intent.getIntExtra("CropImage_filterId", 0);
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_sns_tmp_file, true)) {
                            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                            com.tencent.mm.plugin.recordvideo.e.c.aL(stringArrayListExtra2);
                        }
                        boolean c2 = c(stringArrayListExtra2, intExtra2, booleanExtra);
                        AppMethodBeat.o(98186);
                        return c2;
                    }
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                    } else {
                        stringExtra = stringArrayListExtra.get(0);
                    }
                    String stringExtra3 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                    if (Util.isNullOrNil(stringExtra3) || !s.YS(stringExtra3)) {
                        stringExtra3 = aj.getAccSnsTmpPath() + s.bhK(stringExtra);
                        d dVar = new d();
                        try {
                            dVar.setDataSource(stringExtra);
                            Bitmap frameAtTime = dVar.getFrameAtTime(0);
                            if (frameAtTime == null) {
                                Log.e("MicroMsg.PicWidget", "get bitmap error");
                                try {
                                    dVar.release();
                                    break;
                                } catch (Exception e2) {
                                    break;
                                }
                            } else {
                                Log.i("MicroMsg.PicWidget", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                                BitmapUtil.saveBitmapToImage(frameAtTime, 80, Bitmap.CompressFormat.JPEG, stringExtra3, true);
                                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(stringExtra3);
                                Log.i("MicroMsg.PicWidget", "getBitmap2 %d %d", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                                try {
                                    dVar.release();
                                } catch (Exception e3) {
                                }
                            }
                        } catch (Exception e4) {
                            Log.e("MicroMsg.PicWidget", "savebitmap error %s", e4.getMessage());
                            try {
                                dVar.release();
                            } catch (Exception e5) {
                            }
                        } catch (Throwable th) {
                            try {
                                dVar.release();
                            } catch (Exception e6) {
                            }
                            AppMethodBeat.o(98186);
                            throw th;
                        }
                    }
                    Log.i("MicroMsg.PicWidget", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra3, Long.valueOf(s.boW(stringExtra)), Long.valueOf(s.boW(stringExtra3)));
                    String bhK2 = s.bhK(stringExtra);
                    if (this.gte instanceof SnsUploadUI) {
                        com.tencent.mm.plugin.sns.data.r.aOz(intent.getStringExtra("KSEGMENTMEDIAEDITID"));
                        ((SnsUploadUI) this.gte).a(stringExtra, stringExtra3, bhK2, (byte[]) null, false);
                        ((SnsUploadUI) this.gte).fjO();
                    }
                    AppMethodBeat.o(98186);
                    return true;
                }
                Log.i("MicroMsg.PicWidget", "goto vlog mode");
                this.gte.getIntent().getExtras().clear();
                this.gte.getIntent().putExtra("Kis_take_photo", false);
                this.gte.getIntent().putExtra("KSnsPostManu", true);
                this.gte.getIntent().putExtra("Ksnsupload_type", 14);
                this.gte.getIntent().putExtra("key_extra_data", intent.getBundleExtra("key_extra_data"));
                ((SnsUploadUI) this.gte).fjO();
                AppMethodBeat.o(98186);
                return true;
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.zsy) {
                        String str3 = sightCaptureResult.zsG;
                        if (!Util.isNullOrNil(str3)) {
                            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_sns_tmp_file, true)) {
                                com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                                com.tencent.mm.plugin.recordvideo.e.c.aLE(str3);
                            }
                            boolean c3 = c(Collections.singletonList(str3), 0, true);
                            AppMethodBeat.o(98186);
                            return c3;
                        }
                    } else {
                        String str4 = sightCaptureResult.zsA;
                        String str5 = sightCaptureResult.zsB;
                        byte[] bArr = null;
                        this.gte.getIntent().putExtra("KSightThumbPath", sightCaptureResult.zsB);
                        if (!Util.isNullOrNil(sightCaptureResult.zsD)) {
                            bhK = sightCaptureResult.zsD;
                        } else {
                            bhK = s.bhK(str4);
                        }
                        try {
                            bArr = sightCaptureResult.zsF.toByteArray();
                        } catch (Exception e7) {
                            Log.i("MicroMsg.PicWidget", "put sight extinfo to snsuploadui error: %s", e7.getMessage());
                        }
                        if (this.gte instanceof SnsUploadUI) {
                            ((SnsUploadUI) this.gte).a(str4, str5, bhK, bArr, true);
                            ((SnsUploadUI) this.gte).fjO();
                        }
                        AppMethodBeat.o(98186);
                        return true;
                    }
                }
                break;
        }
        AppMethodBeat.o(98186);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class b {
        ArrayList<String> EuQ = new ArrayList<>();
        Map<String, Boolean> EuR = new HashMap();
        Map<String, Integer> EuS = new HashMap();

        b() {
            AppMethodBeat.i(98168);
            AppMethodBeat.o(98168);
        }

        public final b t(String str, int i2, boolean z) {
            AppMethodBeat.i(98169);
            this.EuQ.add(str);
            this.EuS.put(str, Integer.valueOf(i2));
            this.EuR.put(str, Boolean.valueOf(z));
            AppMethodBeat.o(98169);
            return this;
        }

        public final void aQ(ArrayList<String> arrayList) {
            AppMethodBeat.i(98170);
            this.EuR.clear();
            if (arrayList == null) {
                this.EuQ = new ArrayList<>();
                AppMethodBeat.o(98170);
                return;
            }
            this.EuQ = arrayList;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.EuR.put(it.next(), Boolean.FALSE);
            }
            AppMethodBeat.o(98170);
        }

        public final String toString() {
            AppMethodBeat.i(98171);
            String str = "";
            Iterator<String> it = this.EuQ.iterator();
            while (it.hasNext()) {
                String next = it.next();
                int i2 = 0;
                if (this.EuS != null) {
                    i2 = this.EuS.get(next).intValue();
                }
                str = str + next + "," + i2 + ";";
            }
            AppMethodBeat.o(98171);
            return str;
        }

        public final b aQY(String str) {
            AppMethodBeat.i(98172);
            try {
                for (String str2 : str.split(";")) {
                    String[] split = str2.split(",");
                    this.EuQ.add(split[0]);
                    this.EuS.put(split[0], Integer.valueOf(Util.getInt(split[1], 0)));
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(98172);
            return this;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(98187);
        if (this.EuG != null) {
            this.EuG.clean();
        }
        this.EuH.clear();
        this.EuI.clear();
        AppMethodBeat.o(98187);
        return false;
    }

    public final void fjU() {
        AppMethodBeat.i(259451);
        int size = 9 - this.EuF.EuQ.size();
        if (size <= 0) {
            Log.e("MicroMsg.PicWidget", "has select the max image count");
            AppMethodBeat.o(259451);
            return;
        }
        SightParams sightParams = new SightParams(2, 0);
        com.tencent.mm.modelvideo.o.bhi();
        String aFj = com.tencent.mm.plugin.mmsight.d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
        RecordConfigProvider a2 = RecordConfigProvider.a(aFj, com.tencent.mm.plugin.mmsight.d.aFl(aFj), sightParams.irT, sightParams.irT.duration * 1000, 2);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_ignore_remux_without_edit, false)) {
            a2.remuxType = 2;
        }
        VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
        videoCaptureReportInfo.sQn = 7;
        a2.BOE = videoCaptureReportInfo;
        AnonymousClass8 r0 = new CaptureDataManager.c() {
            /* class com.tencent.mm.plugin.sns.ui.aq.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
            public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                AppMethodBeat.i(98163);
                cly cly = new cly();
                cly.Mrn = true;
                cly.Mrm = false;
                com.tencent.mm.plugin.sns.data.r.aOz(new StringBuilder().append(captureVideoNormalModel.eJJ().y("KEY_EDIT_PUBLISHID_INT", -1)).toString());
                SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.videoPath, captureVideoNormalModel.thumbPath, s.bpb(captureVideoNormalModel.videoPath), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.videoPath), (int) (captureVideoNormalModel.BOd.longValue() / 1000), cly);
                if (captureVideoNormalModel.BOe.booleanValue()) {
                    sightCaptureResult.zsy = true;
                    sightCaptureResult.tkD = false;
                    sightCaptureResult.zsG = captureVideoNormalModel.thumbPath;
                }
                Intent intent = new Intent();
                intent.putExtra("key_req_result", sightCaptureResult);
                ((Activity) context).setResult(-1, intent);
                ((Activity) context).finish();
                AppMethodBeat.o(98163);
            }

            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
            public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                return false;
            }
        };
        long aWz = cl.aWz();
        if (size < 9) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 2, com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(aWz));
            a2.BOs = Boolean.FALSE;
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13822, 1, 2, com.tencent.mm.plugin.sns.data.r.eZx(), Long.valueOf(aWz));
        }
        CaptureDataManager.BOb.BOa = r0;
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true)) {
            com.tencent.mm.plugin.recordvideo.jumper.a aVar = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(this.gte, 11, R.anim.ei, R.anim.ej, a2);
        } else if (size < 9) {
            com.tencent.mm.pluginsdk.ui.tools.s.a(this.gte, 11, new Intent(), 2, 2);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.s.a(this.gte, 11, new Intent(), 2, 0);
        }
        Zy(1);
        AppMethodBeat.o(259451);
    }

    /* access modifiers changed from: package-private */
    public final void Zy(int i2) {
        AppMethodBeat.i(98188);
        ii ahh = new ii().ahh();
        ahh.eOC = (long) i2;
        ahh.wg(this.EsT).bfK();
        AppMethodBeat.o(98188);
    }

    public final Map<String, Boolean> fgI() {
        AppMethodBeat.i(98189);
        HashMap hashMap = new HashMap();
        if (this.EuF != null && !this.EuF.EuQ.isEmpty()) {
            Iterator<String> it = this.EuF.EuQ.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.EuF.EuR.get(next) != null) {
                    hashMap.put(next, this.EuF.EuR.get(next));
                }
            }
        }
        if (this.EuF != null) {
            Map<String, Boolean> map = this.EuF.EuR;
            AppMethodBeat.o(98189);
            return map;
        }
        AppMethodBeat.o(98189);
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        boolean z;
        AppMethodBeat.i(203355);
        if (this.EuF == null || Util.isNullOrNil(this.EuF.EuQ)) {
            z = false;
        } else {
            Iterator<String> it = this.EuF.EuQ.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!s.YS(it.next())) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (!z) {
            com.tencent.mm.ui.base.h.n(this.gte, R.string.hc1, R.string.zb);
        }
        AppMethodBeat.o(203355);
        return z;
    }
}
