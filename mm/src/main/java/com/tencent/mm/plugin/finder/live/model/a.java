package com.tencent.mm.plugin.finder.live.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class a {
    private static final String TAG = TAG;
    public static final a uhJ = new a();

    /* renamed from: com.tencent.mm.plugin.finder.live.model.a$a */
    public static final class C1180a extends q implements b<awi, Boolean> {
        final /* synthetic */ awi uhK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1180a(awi awi) {
            super(1);
            this.uhK = awi;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(awi awi) {
            AppMethodBeat.i(245992);
            awi awi2 = awi;
            p.h(awi2, "item");
            Boolean valueOf = Boolean.valueOf(p.j(awi2.id, this.uhK.id));
            AppMethodBeat.o(245992);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(245996);
        AppMethodBeat.o(245996);
    }

    private a() {
    }

    public static void a(g gVar, LinkedList<aut> linkedList) {
        awr awr;
        auv auv;
        Object obj;
        ave ave;
        Object obj2;
        awr awr2;
        avn avn;
        FinderContact finderContact;
        avn avn2;
        FinderContact finderContact2;
        AppMethodBeat.i(260428);
        p.h(gVar, "roomData");
        StringBuilder sb = new StringBuilder("handleAlertMsg:");
        if (linkedList != null) {
            int i2 = 0;
            awr = null;
            for (T t : linkedList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                sb.append("(" + i2 + ")[msgType:" + (t2 != null ? Integer.valueOf(t2.ybm) : null).intValue() + ",payload is empty:" + ((t2 != null ? t2.LFB : null) == null) + ",fromUser:" + ((t2 == null || (avn2 = t2.LFE) == null || (finderContact2 = avn2.contact) == null) ? null : finderContact2.nickname) + ",toUser:" + ((t2 == null || (avn = t2.LFz) == null || (finderContact = avn.contact) == null) ? null : finderContact.nickname) + "] ");
                if (t2 != null) {
                    switch (t2.ybm) {
                        case 20007:
                            auv auv2 = new auv();
                            com.tencent.mm.bw.b bVar = t2.LFB;
                            try {
                                auv2.parseFrom(bVar != null ? bVar.toByteArray() : null);
                                auv = auv2;
                            } catch (Exception e2) {
                                Log.printDebugStack("safeParser", "", e2);
                                auv = null;
                            }
                            auv auv3 = auv;
                            awr awr3 = auv3 != null ? auv3.LFK : null;
                            String str = TAG;
                            StringBuilder sb2 = new StringBuilder("parseMsgBoxInfo:");
                            if (awr3 == null) {
                                obj = "";
                            } else {
                                obj = awr3;
                            }
                            Log.i(str, sb2.append(com.tencent.mm.ac.g.bN(obj)).toString());
                            if (awr != null) {
                                if (awr3 != null) {
                                    if (awr == null) {
                                        p.hyc();
                                    }
                                    awr = a(awr, awr3);
                                    break;
                                }
                            } else {
                                i2 = i3;
                                awr = awr3;
                                continue;
                            }
                            break;
                        case 20011:
                            ave ave2 = new ave();
                            com.tencent.mm.bw.b bVar2 = t2.LFB;
                            try {
                                ave2.parseFrom(bVar2 != null ? bVar2.toByteArray() : null);
                                ave = ave2;
                            } catch (Exception e3) {
                                Log.printDebugStack("safeParser", "", e3);
                                ave = null;
                            }
                            ave ave3 = ave;
                            awr awr4 = ave3 != null ? ave3.LFK : null;
                            String str2 = TAG;
                            StringBuilder sb3 = new StringBuilder("parseMsgBoxInfo:");
                            if (awr4 == null) {
                                obj2 = "";
                            } else {
                                obj2 = awr4;
                            }
                            Log.i(str2, sb3.append(com.tencent.mm.ac.g.bN(obj2)).toString());
                            if (awr == null) {
                                i2 = i3;
                                awr = awr4;
                                continue;
                            } else {
                                if (awr4 != null) {
                                    if (awr == null) {
                                        p.hyc();
                                    }
                                    awr2 = a(awr, awr4);
                                } else {
                                    awr2 = awr;
                                }
                                i2 = i3;
                                awr = awr2;
                            }
                    }
                }
                i2 = i3;
                awr = awr;
            }
        } else {
            awr = null;
        }
        if (awr != null) {
            d.h(new g.j(gVar, awr));
        }
        Log.i(TAG, sb.toString());
        AppMethodBeat.o(260428);
    }

    private static awr a(awr awr, awr awr2) {
        switch (awr.type) {
            case 20007:
                return awr2.type == 20007 ? awr2 : awr;
            case 20011:
                return (awr2.type == 20011 || awr2.type == 20007) ? awr2 : awr;
            default:
                return awr;
        }
    }

    public static /* synthetic */ void b(g gVar, LinkedList linkedList) {
        AppMethodBeat.i(245995);
        a(gVar, linkedList, false);
        AppMethodBeat.o(245995);
    }

    public static void a(g gVar, LinkedList<axl> linkedList, boolean z) {
        byte[] bArr;
        fgy fgy;
        byte[] bArr2;
        awi awi;
        int i2;
        awi awi2;
        awi awi3;
        AppMethodBeat.i(245994);
        p.h(gVar, "roomData");
        StringBuilder sb = new StringBuilder("updateTemplateInfo(fromJoinLive:" + z + "):");
        LinkedList<awi> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        if (linkedList != null) {
            int i3 = 0;
            for (T t : linkedList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t2 = t;
                sb.append("(" + i3 + ")[msgType:" + (t2 != null ? Integer.valueOf(t2.infoType) : null).intValue() + ",payload is empty:" + ((t2 != null ? t2.LHW : null) == null) + ",versionWording:" + (t2 != null ? t2.LHX : null) + ",seq:" + t2.jlm + "}] ");
                if (t2 != null) {
                    switch (t2.infoType) {
                        case CdnLogic.kMediaLittleAppPacket:
                            awi awi4 = new awi();
                            com.tencent.mm.bw.b bVar = t2.LHW;
                            if (bVar != null) {
                                bArr2 = bVar.toByteArray();
                            } else {
                                bArr2 = null;
                            }
                            try {
                                awi4.parseFrom(bArr2);
                                awi = awi4;
                            } catch (Exception e2) {
                                Log.printDebugStack("safeParser", "", e2);
                                awi = null;
                            }
                            awi awi5 = awi;
                            String str = awi5 != null ? awi5.id : null;
                            if (str == null || gVar.atX(str)) {
                                String str2 = TAG;
                                StringBuilder sb2 = new StringBuilder("updateTemplateInfo ");
                                Object obj = awi5;
                                if (awi5 == null) {
                                    obj = "";
                                }
                                Log.e(str2, sb2.append(com.tencent.mm.ac.g.bN(obj)).append(" fail,").append(str).append(" have show!").toString());
                                i3 = i4;
                            } else {
                                i iVar = gVar.uEa;
                                if (iVar == null || (awi3 = iVar.tWe) == null) {
                                    i2 = Integer.MAX_VALUE;
                                } else {
                                    i2 = awi3.LHb;
                                }
                                i iVar2 = gVar.uEa;
                                if (!p.j(awi5.id, (iVar2 == null || (awi2 = iVar2.tWe) == null) ? null : awi2.id) || awi5.LHb <= i2) {
                                    if (d.a((LinkedList) linkedList2, (b) new C1180a(awi5))) {
                                        Log.i(TAG, "updateTemplateInfo remove the last same item id:" + awi5.id + '!');
                                    }
                                    linkedList2.add(awi5);
                                    i3 = i4;
                                } else {
                                    Log.i(TAG, "updateTemplateInfo drop the old time lottteryInfo:" + com.tencent.mm.ac.g.bN(awi5) + '!');
                                    i3 = i4;
                                    continue;
                                }
                            }
                            break;
                        case 30002:
                            fgy fgy2 = new fgy();
                            com.tencent.mm.bw.b bVar2 = t2.LHW;
                            if (bVar2 != null) {
                                bArr = bVar2.toByteArray();
                            } else {
                                bArr = null;
                            }
                            try {
                                fgy2.parseFrom(bArr);
                                fgy = fgy2;
                            } catch (Exception e3) {
                                Log.printDebugStack("safeParser", "", e3);
                                fgy = null;
                            }
                            fgy fgy3 = fgy;
                            if (fgy3 == null) {
                                Log.i(TAG, "updateTemplateInfo redPackInfo is null!");
                                break;
                            } else {
                                Log.i(TAG, "updateTemplateInfo redPackInfo:" + com.tencent.mm.ac.g.bN(fgy3) + '!');
                                linkedList3.add(fgy3);
                                i3 = i4;
                                continue;
                            }
                    }
                }
                i3 = i4;
            }
        }
        Log.i(TAG, sb.toString());
        if (linkedList2.size() > 0) {
            gVar.b(linkedList2, z);
        }
        if (!(linkedList3.isEmpty())) {
            p.h(linkedList3, "liveMsgRedPacketInfoList");
            d.h(new g.n(gVar, linkedList3, z));
        }
        AppMethodBeat.o(245994);
    }
}
