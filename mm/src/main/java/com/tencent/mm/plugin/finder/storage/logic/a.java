package com.tencent.mm.plugin.finder.storage.logic;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class a {
    public static final a vGJ = new a();

    static {
        AppMethodBeat.i(167088);
        AppMethodBeat.o(167088);
    }

    private a() {
    }

    public static an a(long j2, String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7, String str8, int i2, long j3, boolean z, FinderCommentInfo finderCommentInfo, bbn bbn, int i3) {
        String aYt;
        int i4;
        String str9;
        aoh aoh;
        String str10;
        AppMethodBeat.i(252054);
        p.h(str, "objectNonceId");
        p.h(str2, ch.COL_USERNAME);
        p.h(str3, "feedUsername");
        p.h(str8, "nickname");
        an anVar = new an();
        anVar.field_actionType = 1;
        anVar.field_feedId = j2;
        anVar.field_objectNonceId = str;
        anVar.field_localCommentId = j3;
        anVar.dyb().displayid = 0;
        anVar.FB(finderCommentInfo != null ? finderCommentInfo.commentId : 0);
        if (i2 == 1) {
            anVar.setUsername(str2);
            c.a aVar = c.tsp;
            g asG = c.a.asG(z.aUg());
            if (asG == null || (str10 = asG.cXH()) == null) {
                str10 = "";
            }
            anVar.avC(str10);
        } else {
            String aTY = z.aTY();
            p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
            anVar.setUsername(aTY);
            i Mx = com.tencent.mm.aj.p.aYB().Mx(anVar.getUsername());
            if (Mx != null) {
                String aYt2 = Mx.aYt();
                if (aYt2 == null || aYt2.length() == 0) {
                    aYt = Mx.aYu();
                    p.g(aYt, "imgFlag.smallUrl");
                } else {
                    aYt = Mx.aYt();
                    p.g(aYt, "imgFlag.bigUrl");
                }
                anVar.avC(aYt);
            }
            if (Util.isNullOrNil(anVar.dyc())) {
                anVar.avC("");
            }
        }
        if (str7 != null) {
            p.h(str7, "value");
            anVar.dyb().content = str7;
        }
        p.h(str8, "value");
        anVar.dyb().nickname = str8;
        anVar.FC(cl.aWy() / 1000);
        if (p.j(str2, str3)) {
            i4 = 2;
        } else if (i2 == 1) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        anVar.Lb(i4);
        anVar.field_state = 1;
        if (l != null) {
            l.longValue();
            anVar.dyb().replyCommentId = l.longValue();
            if (str4 == null) {
                str4 = "";
            }
            p.h(str4, "value");
            anVar.dyb().reply_content = str4;
            if (str5 == null) {
                str9 = "";
            } else {
                str9 = str5;
            }
            p.h(str9, "value");
            anVar.dyb().reply_username = str9;
            if (str6 == null) {
                str6 = "";
            }
            p.h(str6, "value");
            anVar.dyb().replyNickname = str6;
            if (Util.isEqual(str5, str3)) {
                anVar.Lb(anVar.dyb().displayFlag | 4);
            }
            if (z) {
                anVar.Lb(anVar.dyb().displayFlag | 16);
            }
            if (finderCommentInfo != null) {
                aoh aoh2 = anVar.field_actionInfo;
                FinderCommentInfo finderCommentInfo2 = new FinderCommentInfo();
                try {
                    finderCommentInfo2.parseFrom(finderCommentInfo.toByteArray());
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    finderCommentInfo2 = null;
                }
                FinderCommentInfo finderCommentInfo3 = finderCommentInfo2;
                if (finderCommentInfo3 != null) {
                    finderCommentInfo3.expandCommentCount--;
                    finderCommentInfo3.upContinueFlag = 0;
                    finderCommentInfo3.continueFlag = finderCommentInfo3.expandCommentCount > 0 ? 1 : 0;
                    LinkedList<FinderCommentInfo> linkedList = finderCommentInfo3.levelTwoComment;
                    if (linkedList != null) {
                        linkedList.clear();
                    }
                    finderCommentInfo3.lastBuffer = null;
                    finderCommentInfo3.displayid = 0;
                    aoh = aoh2;
                } else {
                    finderCommentInfo3 = null;
                    aoh = aoh2;
                }
                aoh.LAn = finderCommentInfo3;
            }
        }
        String valueOf = String.valueOf(j3);
        p.h(valueOf, "value");
        anVar.dyb().client_id = valueOf;
        anVar.field_scene = i2;
        anVar.field_postTime = System.currentTimeMillis();
        anVar.field_tryCount = 0;
        anVar.field_actionInfo.ttO = bbn;
        anVar.field_actionInfo.LAo = i3;
        anVar.dyb().extFlag = 1;
        AppMethodBeat.o(252054);
        return anVar;
    }

    public static s b(an anVar) {
        AppMethodBeat.i(167085);
        p.h(anVar, ImagesContract.LOCAL);
        s sVar = new s(anVar);
        sVar.uNY = l.c(MMApplicationContext.getContext(), sVar.uOf.getContent());
        AppMethodBeat.o(167085);
        return sVar;
    }

    public static /* synthetic */ an a(FinderCommentInfo finderCommentInfo, long j2) {
        AppMethodBeat.i(178425);
        an a2 = a(finderCommentInfo, j2, 0);
        AppMethodBeat.o(178425);
        return a2;
    }

    private static an a(FinderCommentInfo finderCommentInfo, long j2, long j3) {
        AppMethodBeat.i(178424);
        p.h(finderCommentInfo, "info");
        an anVar = new an();
        anVar.field_feedId = j2;
        anVar.field_state = 2;
        p.h(finderCommentInfo, "value");
        anVar.field_actionInfo.LAk = finderCommentInfo;
        anVar.FB(j3);
        AppMethodBeat.o(178424);
        return anVar;
    }

    public static FinderCommentInfo c(an anVar) {
        AppMethodBeat.i(252055);
        p.h(anVar, ImagesContract.LOCAL);
        FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
        finderCommentInfo.username = anVar.getUsername();
        finderCommentInfo.displayid = anVar.dyb().displayid;
        finderCommentInfo.commentId = anVar.dyb().commentId;
        finderCommentInfo.content = anVar.getContent();
        finderCommentInfo.createtime = anVar.dyb().createtime;
        finderCommentInfo.deleteFlag = anVar.dyb().deleteFlag;
        finderCommentInfo.replyCommentId = anVar.dyb().replyCommentId;
        finderCommentInfo.nickname = anVar.getNickname();
        finderCommentInfo.headUrl = anVar.dyc();
        finderCommentInfo.replyNickname = anVar.dyd();
        finderCommentInfo.likeCount = anVar.dyb().likeCount;
        finderCommentInfo.likeFlag = anVar.dyb().likeFlag;
        finderCommentInfo.expandCommentCount = anVar.dyb().expandCommentCount;
        finderCommentInfo.continueFlag = anVar.dyb().continueFlag;
        finderCommentInfo.displayFlag = anVar.dyb().displayFlag;
        finderCommentInfo.blacklist_flag = anVar.dyb().blacklist_flag;
        finderCommentInfo.reply_content = anVar.dye();
        finderCommentInfo.reply_username = anVar.dyf();
        finderCommentInfo.client_id = anVar.dyg();
        finderCommentInfo.extFlag = anVar.dyb().extFlag;
        AppMethodBeat.o(252055);
        return finderCommentInfo;
    }

    public static s b(FinderCommentInfo finderCommentInfo, long j2, long j3) {
        AppMethodBeat.i(178427);
        p.h(finderCommentInfo, "level2CommentInfo");
        s b2 = b(a(finderCommentInfo, j2, j3));
        AppMethodBeat.o(178427);
        return b2;
    }

    public static s b(FinderCommentInfo finderCommentInfo, long j2) {
        AppMethodBeat.i(178426);
        p.h(finderCommentInfo, "level1CommentInfo");
        s b2 = b(a(finderCommentInfo, j2, 0));
        AppMethodBeat.o(178426);
        return b2;
    }
}
