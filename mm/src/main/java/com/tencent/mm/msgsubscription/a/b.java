package com.tencent.mm.msgsubscription.a;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u00039:;B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u0004\u0018\u00010\u001eJ\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u0006H\u0016J,\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u00107\u001a\u0002022\b\u00108\u001a\u0004\u0018\u00010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012¨\u0006<"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", ch.COL_USERNAME, "", "actionType", "", "(Ljava/lang/String;I)V", "isOpened", "", "(Ljava/lang/String;IZ)V", "appId", "(Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()I", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", IssueStorage.COLUMN_EXT_INFO, "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "popupScene", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "sessionId", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "setUsername", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b extends com.tencent.mm.msgsubscription.util.a implements a.b {
    public static final C0463b jzt = new C0463b((byte) 0);
    private final int actionType;
    private String appId;
    private String extInfo;
    private boolean jyo;
    private final List<efc> jzm;
    private a.c jzn;
    public c jzo;
    private String jzp;
    private SubscribeMsgRequestDialogUiData jzq;
    private int jzr;
    private byte[] jzs;
    private String sessionId;
    public String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
    public interface c {
        void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult);
    }

    static {
        AppMethodBeat.i(149573);
        AppMethodBeat.o(149573);
    }

    public b(String str, String str2, int i2) {
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "appId");
        AppMethodBeat.i(194266);
        this.username = str;
        this.appId = str2;
        this.actionType = i2;
        this.jzm = new ArrayList();
        this.jzp = "";
        this.sessionId = "";
        this.extInfo = "";
        this.jzs = new byte[0];
        AppMethodBeat.o(194266);
    }

    public final void setAppId(String str) {
        AppMethodBeat.i(194265);
        p.h(str, "<set-?>");
        this.appId = str;
        AppMethodBeat.o(194265);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(194264);
        p.h(str, "<set-?>");
        this.username = str;
        AppMethodBeat.o(194264);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, int i2) {
        this(str, "", i2);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(149571);
        AppMethodBeat.o(149571);
    }

    public final void au(byte[] bArr) {
        AppMethodBeat.i(149567);
        p.h(bArr, "<set-?>");
        this.jzs = bArr;
        AppMethodBeat.o(149567);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public b(String str, int i2, boolean z) {
        this(str, i2);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(149572);
        this.jyo = z;
        AppMethodBeat.o(149572);
    }

    public final int a(a.AbstractC0480a aVar) {
        boolean z = true;
        AppMethodBeat.i(174564);
        p.h(aVar, "dispatcher");
        a.c.C0481a aVar2 = a.c.jCZ;
        this.jzn = a.c.C0481a.a(new efd(), new efe(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
        a.c cVar = this.jzn;
        if (cVar == null) {
            p.hyc();
        }
        dop bjh = cVar.bjh();
        if (bjh == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
            AppMethodBeat.o(174564);
            throw tVar;
        }
        efd efd = (efd) bjh;
        efd.Nfh = this.jzr;
        efd.SessionId = this.sessionId;
        efd.Nfi = this.extInfo;
        switch (this.actionType) {
            case 1:
            case 6:
                efd.KSV = this.username;
                efd.jfi = this.appId;
                efd.KWb = this.actionType;
                efd.KTf = 1;
                efd.NeZ = this.jyo ? 1 : 0;
                efd.xKD.addAll(this.jzm);
                if (this.actionType == 6) {
                    efd.Buffer = new com.tencent.mm.bw.b(this.jzs);
                    efd.Nfg = new ddg();
                    SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData = this.jzq;
                    if (subscribeMsgRequestDialogUiData != null) {
                        efd.Nfg.MIp = subscribeMsgRequestDialogUiData.jxU;
                        efd.Nfg.him = subscribeMsgRequestDialogUiData.opType;
                        Iterator<SubscribeMsgRequestDialogUiData.ItemUiData> it = subscribeMsgRequestDialogUiData.jxV.iterator();
                        while (it.hasNext()) {
                            SubscribeMsgRequestDialogUiData.ItemUiData next = it.next();
                            LinkedList<efg> linkedList = efd.Nfg.MIq;
                            efg efg = new efg();
                            efg.Mqy = next.ixM;
                            efg.NeX = next.jyd;
                            linkedList.add(efg);
                        }
                        break;
                    }
                }
                break;
            case 2:
            case 3:
            case 5:
                efd.KSV = this.username;
                efd.jfi = this.appId;
                efd.KWb = this.actionType;
                efd.xKD.addAll(this.jzm);
                if (this.jzp.length() <= 0) {
                    z = false;
                }
                if (z) {
                    efd.Nff = this.jzp;
                    break;
                }
                break;
        }
        a.c cVar2 = this.jzn;
        if (cVar2 == null) {
            p.hyc();
        }
        int a2 = aVar.a(cVar2, this, this);
        AppMethodBeat.o(174564);
        return a2;
    }

    @Override // com.tencent.mm.msgsubscription.util.a.b
    public final void k(int i2, int i3, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        int i4;
        String str15;
        String str16;
        AppMethodBeat.i(174565);
        if (i2 == 0 && i3 == 0) {
            a.c cVar = this.jzn;
            if (cVar == null) {
                p.hyc();
            }
            dpc bji = cVar.bji();
            if (bji == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
                AppMethodBeat.o(174565);
                throw tVar;
            }
            efe efe = (efe) bji;
            c cVar2 = this.jzo;
            if (cVar2 != null) {
                if (str == null) {
                    str = "";
                }
                SubscribeMsgRequestResult.a aVar = SubscribeMsgRequestResult.jyx;
                p.h(efe, "response");
                ArrayList arrayList = new ArrayList();
                LinkedList<efc> linkedList = efe.xJg;
                p.g(linkedList, "response.InfoList");
                for (T t : linkedList) {
                    ArrayList arrayList2 = new ArrayList();
                    LinkedList<cgj> linkedList2 = t.KZi;
                    p.g(linkedList2, "it.KeyWordList");
                    for (T t2 : linkedList2) {
                        arrayList2.add(new o(t2.Name, t2.Cyk));
                    }
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList.add(new SubscribeMsgTmpItem(t, arrayList2));
                }
                boolean z = efe.Nfn == 1;
                String str17 = efe.Nfl;
                if (str17 == null) {
                    str2 = "";
                } else {
                    str2 = str17;
                }
                String str18 = efe.Nfk;
                if (str18 == null) {
                    str3 = "";
                } else {
                    str3 = str18;
                }
                int i5 = efe.Nfo;
                boolean z2 = efe.Nfm == 1;
                boolean z3 = efe.NfA == 1;
                efh efh = efe.Nfj;
                if (efh == null || (str4 = efh.jyH) == null) {
                    str4 = "";
                }
                efh efh2 = efe.Nfj;
                if (efh2 == null || (str5 = efh2.jyI) == null) {
                    str5 = "";
                }
                efh efh3 = efe.Nfj;
                if (efh3 == null || (str6 = efh3.jyJ) == null) {
                    str6 = "";
                }
                efh efh4 = efe.Nfj;
                if (efh4 == null || (str7 = efh4.jyK) == null) {
                    str7 = "";
                }
                efh efh5 = efe.Nfj;
                if (efh5 == null || (str8 = efh5.jyL) == null) {
                    str8 = "";
                }
                efh efh6 = efe.Nfj;
                if (efh6 == null || (str9 = efh6.jyM) == null) {
                    str9 = "";
                }
                efh efh7 = efe.Nfj;
                if (efh7 == null || (str10 = efh7.jyN) == null) {
                    str10 = "";
                }
                efh efh8 = efe.Nfj;
                if (efh8 == null || (str11 = efh8.jyO) == null) {
                    str11 = "";
                }
                efh efh9 = efe.Nfj;
                if (efh9 == null || (str12 = efh9.jyP) == null) {
                    str12 = "";
                }
                efh efh10 = efe.Nfj;
                if (efh10 == null || (str13 = efh10.jyQ) == null) {
                    str13 = "";
                }
                efh efh11 = efe.Nfj;
                if (efh11 == null || (str14 = efh11.jyR) == null) {
                    str14 = "";
                }
                WordingInfo wordingInfo = new WordingInfo(str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
                boolean z4 = efe.NeZ == 1;
                boolean z5 = efe.Nfs == 1;
                com.tencent.mm.bw.b bVar = efe.Buffer;
                byte[] byteArray = bVar != null ? bVar.toByteArray() : new byte[0];
                int i6 = efe.Nfy;
                eff eff = efe.Nfz;
                if (eff != null) {
                    i4 = eff.MmV;
                } else {
                    i4 = -1;
                }
                eff eff2 = efe.Nfz;
                if (eff2 == null || (str15 = eff2.Mdz) == null) {
                    str15 = "";
                }
                eff eff3 = efe.Nfz;
                if (eff3 == null || (str16 = eff3.NfB) == null) {
                    str16 = "";
                }
                ShowInfo showInfo = new ShowInfo(i4, str15, str16);
                String str19 = efe.Nfw;
                if (str19 == null) {
                    str19 = "";
                }
                String str20 = efe.Nfx;
                if (str20 == null) {
                    str20 = "";
                }
                int i7 = efe.Nft;
                String str21 = efe.Nfu;
                if (str21 == null) {
                    str21 = "";
                }
                boolean z6 = efe.Nfv;
                String str22 = efe.Nfi;
                if (str22 == null) {
                    str22 = "";
                }
                cVar2.a(i2, i3, str, new SubscribeMsgRequestResult(z, str2, str3, i5, arrayList, z2, z3, wordingInfo, z4, z5, byteArray, i6, showInfo, str19, str20, i7, str21, z6, str22));
                AppMethodBeat.o(174565);
                return;
            }
            AppMethodBeat.o(174565);
            return;
        }
        c cVar3 = this.jzo;
        if (cVar3 != null) {
            if (str == null) {
                str = "";
            }
            cVar3.a(i2, i3, str, null);
            AppMethodBeat.o(174565);
            return;
        }
        AppMethodBeat.o(174565);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Companion;", "", "()V", "ACTION_GET_ALL_SUBSCRIBE_STATUS", "", "ACTION_GET_SUBSCRIBE_STATUS", "ACTION_GET_UI_STATUS", "ACTION_SUBSCRIBE", "ACTION_SUBSCRIBE_FOR_DIALOG_REQUEST", "FUNC_FLAG_SET_IS_OPEN", "POPUP_SCENE_DEFAULT", "POPUP_SCENE_H5", "POPUP_SCENE_MP", "POPUP_SCENE_MP_PREVIEW", "POPUP_SCENE_TEXT_LINK", "TAG", "", "URI", ShareConstants.ACTION, "PopupScene", "wxbiz-msgsubscription-sdk_release"})
    /* renamed from: com.tencent.mm.msgsubscription.a.b$b  reason: collision with other inner class name */
    public static final class C0463b {
        private C0463b() {
        }

        public /* synthetic */ C0463b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
    public static final class a {
        public static final C0462a jzu = new C0462a((byte) 0);

        static {
            AppMethodBeat.i(149566);
            AppMethodBeat.o(149566);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ>\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ8\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JV\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJF\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ^\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004H\u0002¨\u0006!"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", ch.COL_USERNAME, "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatus", "appId", "subscribeUrl", "templateIds", "", IssueStorage.COLUMN_EXT_INFO, "buildGetSubscribeStatusReq", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", NativeProtocol.WEB_DIALOG_ACTION, "", "processExtInfo", "", "req", "wxbiz-msgsubscription-sdk_release"})
        /* renamed from: com.tencent.mm.msgsubscription.a.b$a$a  reason: collision with other inner class name */
        public static final class C0462a {
            private C0462a() {
            }

            public /* synthetic */ C0462a(byte b2) {
                this();
            }

            public static b a(String str, String str2, List<SubscribeMsgTmpItem> list, String str3, c cVar, boolean z, byte[] bArr, SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData) {
                AppMethodBeat.i(194259);
                p.h(str, ch.COL_USERNAME);
                p.h(str2, "appId");
                p.h(list, "templates");
                p.h(str3, IssueStorage.COLUMN_EXT_INFO);
                p.h(bArr, "byteArray");
                b a2 = a(str, str2, z, cVar, list, 6, bArr, subscribeMsgRequestDialogUiData, str3);
                AppMethodBeat.o(194259);
                return a2;
            }

            public static b a(String str, String str2, String str3, List<String> list, String str4, c cVar) {
                AppMethodBeat.i(194260);
                p.h(str, ch.COL_USERNAME);
                p.h(str2, "appId");
                p.h(str3, "subscribeUrl");
                p.h(list, "templateIds");
                p.h(str4, IssueStorage.COLUMN_EXT_INFO);
                b bVar = new b(str, str2, 2);
                a(str4, bVar);
                bVar.jzo = cVar;
                bVar.jzp = str3;
                for (String str5 : list) {
                    List list2 = bVar.jzm;
                    efc efc = new efc();
                    efc.Mqy = str5;
                    list2.add(efc);
                }
                AppMethodBeat.o(194260);
                return bVar;
            }

            public static b a(String str, c cVar) {
                AppMethodBeat.i(149564);
                p.h(str, ch.COL_USERNAME);
                b bVar = new b(str, 3);
                bVar.jzo = cVar;
                AppMethodBeat.o(149564);
                return bVar;
            }

            public static /* synthetic */ b a(String str, String str2, boolean z, c cVar, List list, byte[] bArr) {
                AppMethodBeat.i(194262);
                b a2 = a(str, str2, z, cVar, list, 1, bArr, null, "");
                AppMethodBeat.o(194262);
                return a2;
            }

            private static b a(String str, String str2, boolean z, c cVar, List<SubscribeMsgTmpItem> list, int i2, byte[] bArr, SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData, String str3) {
                AppMethodBeat.i(194261);
                b bVar = new b(str, i2, z);
                bVar.setAppId(str2);
                bVar.jzo = cVar;
                bVar.au(bArr);
                bVar.jzq = subscribeMsgRequestDialogUiData;
                a(str3, bVar);
                for (SubscribeMsgTmpItem subscribeMsgTmpItem : list) {
                    List list2 = bVar.jzm;
                    efc efc = new efc();
                    efc.Mqy = subscribeMsgTmpItem.ixM;
                    efc.NeU = subscribeMsgTmpItem.jyz;
                    efc.NeY = subscribeMsgTmpItem.jyB;
                    efc.NeZ = subscribeMsgTmpItem.VC ? 1 : 0;
                    list2.add(efc);
                }
                AppMethodBeat.o(194261);
                return bVar;
            }

            private static void a(String str, b bVar) {
                boolean z;
                AppMethodBeat.i(194263);
                if (str.length() > 0) {
                    bVar.extInfo = str;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        bVar.jzr = jSONObject.optInt("scene");
                        String optString = jSONObject.optString("sessionid");
                        p.g(optString, "ext.optString(\"sessionid\")");
                        bVar.sessionId = optString;
                        String optString2 = jSONObject.optString(ch.COL_USERNAME);
                        p.g(optString2, "extUsername");
                        if (optString2.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            bVar.setUsername(optString2);
                        }
                        Log.i("NetSceneSubscribeMsg", "alvinluo parseExtInfo scene: %s, sessionId: %s, username: %s, extInfo: %s", Integer.valueOf(bVar.jzr), bVar.sessionId, bVar.username, str);
                        AppMethodBeat.o(194263);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("NetSceneSubscribeMsg", e2, "parse extInfo exception", new Object[0]);
                    }
                }
                AppMethodBeat.o(194263);
            }
        }
    }
}
