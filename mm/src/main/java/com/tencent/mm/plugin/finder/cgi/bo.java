package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0003H\u0016J>\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bo extends ax {
    private static final String TAG = TAG;
    private static final int tvv = 1;
    private static final int tvw = 2;
    public static final a tvx = new a((byte) 0);
    private i callback;
    public final LinkedList<ao> gZp = new LinkedList<>();
    private d rr;
    public int scene;
    public int tvu;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static int Ik(int i2) {
            AppMethodBeat.i(242438);
            switch (i2) {
                case 1:
                    int i3 = bo.tvw;
                    AppMethodBeat.o(242438);
                    return i3;
                case 2:
                    int i4 = bo.tvv;
                    AppMethodBeat.o(242438);
                    return i4;
                default:
                    AppMethodBeat.o(242438);
                    return 0;
            }
        }
    }

    static {
        AppMethodBeat.i(165232);
        AppMethodBeat.o(165232);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bo(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 742
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.bo.<init>(int, int):void");
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 978;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165229);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165229);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        String str2;
        AppMethodBeat.i(242439);
        Log.i(TAG, "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
                AppMethodBeat.o(242439);
                throw tVar;
            }
            b bVar = ((ate) aYK).tsO;
            com.tencent.mm.bw.a aYK2 = this.rr.aYK();
            if (aYK2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
                AppMethodBeat.o(242439);
                throw tVar2;
            }
            ayo ayo = ((ate) aYK2).LEb;
            if (ayo != null) {
                Log.i(TAG, "GetMentionList size " + ayo.LIP.size());
                LinkedList<ayk> linkedList = ayo.LIP;
                p.g(linkedList, "it.mentions");
                linkedList.isEmpty();
                LinkedList<ayk> linkedList2 = ayo.LIP;
                p.g(linkedList2, "mentionList.mentions");
                for (T t : linkedList2) {
                    LinkedList<ao> linkedList3 = this.gZp;
                    e.a aVar = e.vGT;
                    p.g(t, "mention");
                    p.h(t, "mention");
                    ao aoVar = new ao();
                    aoVar.field_headUrl = t.headUrl;
                    if (t.LII != 0) {
                        aym aym = new aym();
                        aym.LII = t.LII;
                        aym.LIH = t.LIH;
                        aoVar.field_aggregatedContacts = aym;
                    } else {
                        aoVar.field_aggregatedContacts = new aym();
                    }
                    aoVar.field_nickname = t.nickName;
                    aoVar.field_type = t.LEa;
                    aoVar.field_content = t.LIB;
                    aoVar.field_createTime = t.iXu;
                    aoVar.field_thumbUrl = t.thumbUrl;
                    aoVar.field_id = t.id;
                    aoVar.field_objectId = t.hFK;
                    aoVar.field_objectNonceId = t.objectNonceId;
                    aoVar.field_commentId = t.commentId;
                    aoVar.field_flag = t.cSx;
                    aoVar.field_refContent = t.LIC;
                    aoVar.field_extFlag = t.extFlag;
                    aoVar.field_notify = t.LID;
                    aoVar.field_mediaType = t.mediaType;
                    aoVar.field_description = t.description;
                    aoVar.field_replayUsername = t.LBr;
                    aoVar.field_replayNickname = t.replyNickname;
                    aoVar.field_username = t.username;
                    ayn ayn = t.LIE;
                    aoVar.field_contact = ayn != null ? ayn.contact : null;
                    ayn ayn2 = t.LIF;
                    aoVar.field_replyContact = ayn2 != null ? ayn2.contact : null;
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aoVar.field_userVersion = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, 0);
                    aoVar.field_followExpireTime = (long) t.LIJ;
                    aoVar.field_clientMsgId = t.fQY;
                    aoVar.field_followId = t.LCX;
                    aoVar.field_objectType = (long) t.objectType;
                    aoVar.field_refVideoObjectId = t.LIK;
                    aoVar.field_refVideoObjectNonceId = t.LIL;
                    linkedList3.add(aoVar);
                }
                LinkedList<ayk> linkedList4 = ayo.LIP;
                p.g(linkedList4, "it.mentions");
                linkedList4.isEmpty();
                LinkedList<ayk> linkedList5 = ayo.LIP;
                p.g(linkedList5, "mentionList.mentions");
                for (T t2 : linkedList5) {
                    if (t2.LEa == 10 && !Util.isNullOrNil(t2.fQY)) {
                        Log.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + t2.username + ", clientMsgId:" + t2.fQY + " scene:" + this.scene);
                        e.a aVar2 = e.vGT;
                        String str3 = t2.fQY;
                        if (str3 == null) {
                            str2 = "";
                        } else {
                            str2 = str3;
                        }
                        int i5 = this.scene;
                        p.h(str2, "clientMsgId");
                        MAutoStorage<cm> mentionStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMentionStorage(e.a.Li(i5));
                        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        int i6 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_USER_AUTO_INCREMENT_ID_INT_SYNC, 0);
                        String str4 = e.a.Li(i5) == 1 ? cm.fFi : cm.fFh;
                        String str5 = "DELETE FROM " + str4 + ' ' + " WHERE type=10  AND clientMsgId='" + str2 + "'  AND userVersion=" + i6 + ' ';
                        String str6 = "SELECT * FROM " + str4 + ' ' + " WHERE type=10  AND clientMsgId='" + str2 + "'  AND userVersion=" + i6 + ' ';
                        if (BuildInfo.IS_FLAVOR_PURPLE) {
                            Cursor rawQuery = mentionStorage.rawQuery(str6, new String[0]);
                            boolean execSQL = mentionStorage.execSQL(str4, str5);
                            Cursor rawQuery2 = mentionStorage.rawQuery(str6, new String[0]);
                            String str7 = e.TAG;
                            StringBuilder sb = new StringBuilder("removePrivateMention, before:");
                            p.g(rawQuery, "q1");
                            StringBuilder append = sb.append(rawQuery.getCount()).append(", after:");
                            p.g(rawQuery2, "q2");
                            Log.i(str7, append.append(rawQuery2.getCount()).append(", querySql:").append(str6).toString());
                            Log.i(e.TAG, "removePrivateMention, succ " + execSQL + ",  sql " + str5);
                        } else {
                            Log.i(e.TAG, "removePrivateMention, succ " + mentionStorage.execSQL(str4, str5) + ",  sql " + str5);
                        }
                    }
                }
                if (!this.gZp.isEmpty()) {
                    e.a aVar3 = e.vGT;
                    e.a.t(this.gZp, this.scene);
                }
            }
            if (bVar != null) {
                int i7 = this.scene;
                int i8 = this.tvu;
                byte[] byteArray = bVar.toByteArray();
                p.g(byteArray, "it.toByteArray()");
                int Ik = a.Ik(i7);
                if (Ik == tvw) {
                    switch (i8) {
                        case 1:
                            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh3, "MMKernel.storage()");
                            aAh3.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh4, "MMKernel.storage()");
                            aAh4.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                            break;
                        case 2:
                            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh5, "MMKernel.storage()");
                            aAh5.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh6, "MMKernel.storage()");
                            aAh6.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_SYSTEM_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                            break;
                        case 3:
                            com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh7, "MMKernel.storage()");
                            aAh7.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                            com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh8, "MMKernel.storage()");
                            aAh8.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_LIKE_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                            break;
                        case 4:
                            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh9, "MMKernel.storage()");
                            aAh9.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh10, "MMKernel.storage()");
                            aAh10.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_COMMENT_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                            break;
                        case 5:
                            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh11, "MMKernel.storage()");
                            aAh11.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh12, "MMKernel.storage()");
                            aAh12.azQ().set(ar.a.USERINFO_FINDER_GET_FINDER_IDENTITY_FOLLOW_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                            break;
                    }
                } else if (Ik == tvv) {
                    com.tencent.mm.kernel.e aAh13 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh13, "MMKernel.storage()");
                    aAh13.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_STRING_SYNC, Util.encodeHexString(byteArray));
                    com.tencent.mm.kernel.e aAh14 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh14, "MMKernel.storage()");
                    aAh14.azQ().set(ar.a.USERINFO_FINDER_GET_WX_IDENTITY_NORMAL_MSG_LAST_BUF_WRITE_INT_SYNC, (Object) 1);
                }
            }
            if (bVar != null && bVar.zy.length == 0) {
                int Ik2 = a.Ik(this.scene);
                if (Ik2 == tvw) {
                    switch (this.tvu) {
                        case 1:
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 50, 1, false);
                            break;
                        case 2:
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 51, 1, false);
                            break;
                    }
                } else if (Ik2 == tvv) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 52, 1, false);
                }
            }
            Log.i(TAG, "lastBuf " + (bVar == null ? BuildConfig.COMMAND : Integer.valueOf(bVar.zy.length)));
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242439);
    }
}
