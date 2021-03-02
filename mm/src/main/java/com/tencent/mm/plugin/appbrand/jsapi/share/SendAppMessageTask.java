package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.fci;
import com.tencent.mm.protocal.protobuf.fcj;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SendAppMessageTask extends MainProcessTask {
    public static final Parcelable.Creator<SendAppMessageTask> CREATOR = new Parcelable.Creator<SendAppMessageTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SendAppMessageTask[] newArray(int i2) {
            return new SendAppMessageTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SendAppMessageTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46797);
            SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(parcel);
            AppMethodBeat.o(46797);
            return sendAppMessageTask;
        }
    };
    public String appId;
    public int appVersion;
    public String cacheKey;
    public String dCw;
    public int dMe;
    public String description;
    public String ebj;
    public String eda;
    public int fuQ = k.a.BUSINESS_MAX.ordinal();
    public String iconUrl;
    public String ivd;
    public String ivp;
    public boolean ivq = false;
    public String ixM;
    public boolean lSk;
    public int leb;
    public String lhn;
    public int lyE;
    public Runnable lyv;
    public String mrD;
    public String mrI;
    public String mrJ;
    public boolean mrn;
    public boolean mro;
    public boolean mrp;
    public boolean mru;
    public int mrw;
    public String mrx;
    public String msd;
    public String mse;
    public String msf;
    public String msh;
    public int msi = 1;
    public int msj;
    public String msk;
    public String msl;
    public String msm;
    public boolean msn;
    public String mso;
    public String msp;
    public String msq;
    public String msr;
    public String mss;
    public ArrayList<ShareInfo> mst;
    public String nickname;
    public String path;
    public int scene = 1000;
    public int serviceType;
    public int subType = 0;
    public String title;
    public String toUser;
    public int type;
    public String url;
    public String userName;
    public int version;
    public String videoPath;
    public boolean withShareTicket;

    static /* synthetic */ void a(SendAppMessageTask sendAppMessageTask, k.b bVar, byte[] bArr, String str, StringBuilder sb, int i2) {
        AppMethodBeat.i(46807);
        sendAppMessageTask.b(bVar, bArr, str, sb, i2);
        AppMethodBeat.o(46807);
    }

    public SendAppMessageTask() {
        AppMethodBeat.i(46798);
        AppMethodBeat.o(46798);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        Bitmap bitmap;
        int i2 = 3;
        AppMethodBeat.i(46799);
        Log.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", this.userName, this.mse);
        final byte[] bArr = new byte[0];
        if (!Util.isNullOrNil(this.mse) && (this.mse.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || this.mse.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
            bitmap = b.aXY().a(this.mse, (b.f) null);
        } else if (!Util.isNullOrNil(this.msf)) {
            bitmap = BitmapUtil.getBitmapNative(this.msf);
            if (this.lSk) {
                Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", this.msf, Boolean.valueOf(s.deleteFile(this.msf)));
            } else {
                Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", this.msf);
            }
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Log.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            Log.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            Log.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", createBitmap);
            createBitmap.recycle();
        }
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", this.appId, this.title, this.description, this.userName, this.path, this.mse);
        ad.aVe().G(ad.JX("wxapp_" + this.appId + this.path), true).l("prePublishId", "wxapp_" + this.appId + this.path);
        final k.b bVar = new k.b();
        bVar.title = this.title;
        bVar.description = this.description;
        bVar.izi = this.userName;
        bVar.izh = this.path;
        bVar.izj = this.appId;
        bVar.izz = this.dMe;
        bVar.izA = this.version;
        bVar.izl = this.lhn;
        bVar.izk = this.type;
        bVar.izr = this.lyE;
        bVar.url = this.url;
        bVar.izB = this.iconUrl;
        bVar.eam = "wxapp_" + this.appId + this.path;
        bVar.eag = this.userName;
        bVar.eah = this.nickname;
        a aVar = new a();
        aVar.iuQ = this.mrn;
        aVar.iuR = this.cacheKey;
        aVar.iuS = this.serviceType;
        aVar.iuT = this.mro;
        aVar.ive = this.eda;
        aVar.imageUrl = this.mse;
        aVar.ivh = Util.isNullOrNil(this.mse);
        aVar.ivc = this.leb;
        aVar.ivq = this.ivq;
        aVar.ivf = this.subType;
        bVar.a(aVar);
        final StringBuilder bN = y.bN(this.appId, this.msj);
        bVar.izn = bN.toString();
        z zVar = new z();
        zVar.msM = 1;
        zVar.msN = this.title;
        zVar.msO = this.path;
        zVar.msP = this.mse;
        zVar.msQ = this.mrw;
        aa.a(bVar.izn, zVar);
        if (1 == this.msi) {
            bVar.type = 33;
        } else if (2 == this.msi) {
            bVar.type = 44;
            bVar.izp = this.fuQ;
            bVar.izq = this.msh;
            bVar.izs = this.mrI;
            bVar.izt = this.mrJ;
        } else if (this.msi == 3) {
            bVar.type = 46;
            bVar.appId = this.mso;
            bVar.appName = this.msp;
            bVar.eag = this.msq;
            bVar.eah = null;
            aVar.appThumbUrl = this.msr;
        } else if (this.msi == 4) {
            bVar.type = 48;
            FilePathGenerator.checkMkdir(com.tencent.mm.loader.j.b.aLo());
            String str = com.tencent.mm.loader.j.b.aLo() + this.ebj;
            if (!str.equals(this.videoPath)) {
                Log.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", str, Long.valueOf(s.nw(this.videoPath, str)));
            }
            aVar.ivl = str;
            aVar.ebj = this.ebj;
            aVar.ivn = this.mrD;
            aVar.ivp = this.ivp;
        } else if (this.msi == 5) {
            bVar.type = 5;
            bVar.thumburl = this.mse;
        }
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", Boolean.valueOf(this.mro), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.mru), Boolean.valueOf(this.mrp));
        if ((!this.mro || !this.withShareTicket) && !this.withShareTicket && !this.mru && !this.mrp) {
            Iterator it = new LinkedList(Util.stringsToList(this.toUser.split(","))).iterator();
            while (it.hasNext()) {
                b(bVar, bArr, (String) it.next(), bN, this.scene);
            }
            AppMethodBeat.o(46799);
            return;
        }
        final int i3 = this.scene;
        boolean z = this.mro;
        boolean z2 = this.mrp;
        String str2 = this.ixM;
        d.a aVar2 = new d.a();
        aVar2.funcId = FaceManager.FACE_ACQUIRED_NO_FOCUS;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        fci fci = new fci();
        fci.dNI = this.appId;
        final LinkedList<String> linkedList = new LinkedList<>(Util.stringsToList(this.toUser.split(",")));
        fci.Nyh = linkedList;
        fci.Nyj = str2;
        fci.Nyi = z;
        fci.Nyk = this.mru;
        fci.Nhv = this.ivd;
        fci.Nyl = z2;
        if (!z2) {
            i2 = 0;
        }
        fci.LEg = i2;
        aVar2.iLN = fci;
        aVar2.iLO = new fcj();
        aa.a(aVar2.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                fcr fcr;
                no.c cVar;
                AppMethodBeat.i(46796);
                Log.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                fcj fcj = (fcj) dVar.iLL.iLR;
                if (i2 != 0 || i3 != 0 || fcj == null || Util.isNullOrNil(fcj.Nym)) {
                    if (bVar.izk == 3) {
                        bVar.izk = 2;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        SendAppMessageTask.a(SendAppMessageTask.this, bVar, bArr, (String) it.next(), bN, i3);
                    }
                } else {
                    LinkedList<fcr> linkedList = fcj.Nym;
                    SendAppMessageTask.this.mst = new ArrayList<>();
                    for (int i4 = 0; i4 < linkedList.size(); i4++) {
                        if (i4 < linkedList.size()) {
                            fcr = linkedList.get(i4);
                        } else {
                            fcr = new fcr();
                        }
                        bVar.izo = fcr.MXx;
                        SendAppMessageTask.this.mst.add(new ShareInfo(fcr.MXx, fcr.NyA));
                        a aVar = (a) bVar.as(a.class);
                        aVar.iuT = fcr.Nyi;
                        aVar.ivg = fcr.Nyl;
                        if (fcr.Nyi && fcr.NyB != null) {
                            aVar.iuU = fcr.NyB.content;
                            aVar.iuV = fcr.NyB.MXr;
                            aVar.iuW = fcr.NyB.MXs;
                            aVar.iuX = fcr.NyB.MXt;
                            aVar.iuY = fcr.NyB.MXu;
                            aVar.iuZ = fcr.NyB.MXw;
                            aVar.ivb = fcr.NyB.state;
                            aVar.iva = fcr.NyB.MXv;
                            no AM = new no().AJ(SendAppMessageTask.this.appId).AK(SendAppMessageTask.this.path).AL(fcr.MXx).AM((String) linkedList.get(i4));
                            if (((String) linkedList.get(i4)).toLowerCase().endsWith("@chatroom")) {
                                cVar = no.c.YES;
                            } else {
                                cVar = no.c.NO;
                            }
                            AM.fhy = cVar;
                            AM.fhz = no.b.SHAREAPPMSG;
                            AM.erW = (long) i3;
                            no AN = AM.AN(SendAppMessageTask.this.dCw);
                            AN.fhD = no.a.mX(SendAppMessageTask.this.serviceType + 1000);
                            no ajq = AN.ajq();
                            ajq.fhB = no.d.DOING;
                            ajq.fhC = no.e.NOTSUBSCRIBE;
                            ajq.bfK();
                        }
                        if (fcr.Nyk && fcr.NyC != null && fcr.NyC.Nhu) {
                            aVar.ivd = fcr.NyC.Nhv;
                        }
                        SendAppMessageTask.a(SendAppMessageTask.this, bVar, bArr, (String) linkedList.get(i4), bN, i3);
                    }
                }
                SendAppMessageTask.a(SendAppMessageTask.this);
                AppMethodBeat.o(46796);
                return 0;
            }
        });
        AppMethodBeat.o(46799);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(46800);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(46800);
    }

    private void a(k.b bVar, byte[] bArr, String str, StringBuilder sb, int i2) {
        AppMethodBeat.i(46802);
        w.a.aSz().a(bVar, this.appId, this.title, str, null, bArr);
        if (!Util.isNullOrNil(this.msd)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str;
            twVar.eaq.content = this.msd;
            twVar.eaq.type = ab.JG(str);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        int i3 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> Kh = ((c) g.af(c.class)).aSX().Kh(str);
            i3 = Kh != null ? Kh.size() : 0;
        }
        y.a(this.appId, i2, this.dCw, this.msk, str, this.title, this.path, this.msl, this.msm, i3, sb.toString(), this.mrx, this.serviceType, this.mse, this.appVersion, ab.Eq(str) ? 2 : 1, this.eda);
        AppMethodBeat.o(46802);
    }

    private void b(k.b bVar, byte[] bArr, String str, StringBuilder sb, int i2) {
        AppMethodBeat.i(46803);
        a(bVar, bArr, str, sb, i2);
        AppMethodBeat.o(46803);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(46804);
        this.appId = parcel.readString();
        this.userName = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.msd = parcel.readString();
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.mse = parcel.readString();
        this.iconUrl = parcel.readString();
        this.msf = parcel.readString();
        this.lSk = parcel.readInt() == 1;
        this.dMe = parcel.readInt();
        this.lhn = parcel.readString();
        this.version = parcel.readInt();
        this.nickname = parcel.readString();
        this.msj = parcel.readInt();
        this.scene = parcel.readInt();
        this.dCw = parcel.readString();
        this.msk = parcel.readString();
        this.msl = parcel.readString();
        this.msm = parcel.readString();
        this.withShareTicket = parcel.readByte() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mrn = z;
        if (parcel.readInt() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mro = z2;
        this.ixM = parcel.readString();
        if (parcel.readInt() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.mrp = z3;
        this.cacheKey = parcel.readString();
        this.serviceType = parcel.readInt();
        this.mrx = parcel.readString();
        this.mst = parcel.readArrayList(SendAppMessageTask.class.getClassLoader());
        this.eda = parcel.readString();
        this.appVersion = parcel.readInt();
        this.fuQ = parcel.readInt();
        this.msh = parcel.readString();
        this.lyE = parcel.readInt();
        this.msi = parcel.readInt();
        this.mso = parcel.readString();
        this.msp = parcel.readString();
        this.msq = parcel.readString();
        this.msr = parcel.readString();
        this.msn = parcel.readInt() == 1;
        this.videoPath = parcel.readString();
        this.ebj = parcel.readString();
        this.mss = parcel.readString();
        this.mrD = parcel.readString();
        this.ivp = parcel.readString();
        this.leb = parcel.readInt();
        if (parcel.readInt() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mru = z4;
        this.ivd = parcel.readString();
        if (parcel.readInt() != 1) {
            z5 = false;
        }
        this.ivq = z5;
        this.subType = parcel.readInt();
        this.mrI = parcel.readString();
        this.mrJ = parcel.readString();
        this.mrw = parcel.readInt();
        AppMethodBeat.o(46804);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        AppMethodBeat.i(46805);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.appId);
        parcel.writeString(this.userName);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.msd);
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeString(this.mse);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.msf);
        parcel.writeInt(this.lSk ? 1 : 0);
        parcel.writeInt(this.dMe);
        parcel.writeString(this.lhn);
        parcel.writeInt(this.version);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.msj);
        parcel.writeInt(this.scene);
        parcel.writeString(this.dCw);
        parcel.writeString(this.msk);
        parcel.writeString(this.msl);
        parcel.writeString(this.msm);
        parcel.writeByte((byte) (this.withShareTicket ? 1 : 0));
        if (this.mrn) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (this.mro) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        parcel.writeString(this.ixM);
        if (this.mrp) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        parcel.writeInt(i5);
        parcel.writeString(this.cacheKey);
        parcel.writeInt(this.serviceType);
        parcel.writeString(this.mrx);
        parcel.writeList(this.mst);
        parcel.writeString(this.eda);
        parcel.writeInt(this.appVersion);
        parcel.writeInt(this.fuQ);
        parcel.writeString(this.msh);
        parcel.writeInt(this.lyE);
        parcel.writeInt(this.msi);
        parcel.writeString(this.mso);
        parcel.writeString(this.msp);
        parcel.writeString(this.msq);
        parcel.writeString(this.msr);
        parcel.writeInt(this.msn ? 1 : 0);
        parcel.writeString(this.videoPath);
        parcel.writeString(this.ebj);
        parcel.writeString(this.mss);
        parcel.writeString(this.mrD);
        parcel.writeString(this.ivp);
        parcel.writeInt(this.leb);
        if (this.mru) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        parcel.writeInt(i6);
        parcel.writeString(this.ivd);
        if (!this.ivq) {
            i7 = 0;
        }
        parcel.writeInt(i7);
        parcel.writeInt(this.subType);
        parcel.writeString(this.mrI);
        parcel.writeString(this.mrJ);
        parcel.writeInt(this.mrw);
        AppMethodBeat.o(46805);
    }

    protected SendAppMessageTask(Parcel parcel) {
        AppMethodBeat.i(46806);
        f(parcel);
        AppMethodBeat.o(46806);
    }

    static {
        AppMethodBeat.i(46809);
        AppMethodBeat.o(46809);
    }

    static /* synthetic */ void a(SendAppMessageTask sendAppMessageTask) {
        AppMethodBeat.i(46808);
        sendAppMessageTask.bDU();
        AppMethodBeat.o(46808);
    }
}
