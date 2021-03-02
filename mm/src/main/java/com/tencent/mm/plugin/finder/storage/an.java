package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010w\u001a\u00020xJ\u0006\u0010y\u001a\u00020xJ\u0006\u0010z\u001a\u00020xJ\u0006\u0010{\u001a\u00020xJ\u0006\u0010|\u001a\u00020xJ\u0006\u0010}\u001a\u00020xJ\u0006\u0010~\u001a\u00020xJ\u0006\u0010\u001a\u00020xJ\t\u0010\u0001\u001a\u00020\rH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R$\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR$\u0010%\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R$\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR$\u0010.\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R$\u00101\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R$\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR$\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR$\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR$\u0010=\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R$\u0010@\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R(\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0003\u001a\u0004\u0018\u00010C8F@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HRl\u0010K\u001a&\u0012\f\u0012\n J*\u0004\u0018\u00010\u00190\u0019 J*\u0012\u0012\f\u0012\n J*\u0004\u0018\u00010\u00190\u0019\u0018\u00010I0I2*\u0010\u0003\u001a&\u0012\f\u0012\n J*\u0004\u0018\u00010\u00190\u0019 J*\u0012\u0012\f\u0012\n J*\u0004\u0018\u00010\u00190\u0019\u0018\u00010I0I8F@FX\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR$\u0010S\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR$\u0010V\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010\u0012R$\u0010Y\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u0010\"\u0004\b[\u0010\u0012R$\u0010\\\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR$\u0010_\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b`\u0010\u0016\"\u0004\ba\u0010\u0018R$\u0010b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R$\u0010e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bf\u0010\u0010\"\u0004\bg\u0010\u0012R$\u0010h\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bi\u0010\u0010\"\u0004\bj\u0010\u0012R$\u0010k\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\bl\u0010\u0016\"\u0004\bm\u0010\u0018R$\u0010n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bo\u0010\u0007\"\u0004\bp\u0010\tR$\u0010q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\br\u0010\u0007\"\u0004\bs\u0010\tR$\u0010t\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bu\u0010\u0010\"\u0004\bv\u0010\u0012¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", ClientInfoTable.Columns.CLIENTID, "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", ch.COL_USERNAME, "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class an extends am {
    public static final a vFt = new a((byte) 0);

    static {
        AppMethodBeat.i(167037);
        AppMethodBeat.o(167037);
    }

    public an() {
        AppMethodBeat.i(167036);
        aoh aoh = new aoh();
        aoh.LAk = new FinderCommentInfo();
        aoh.LAl = new cjq();
        aoh.LAm = new cjr();
        this.field_actionInfo = aoh;
        AppMethodBeat.o(167036);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final FinderCommentInfo dyb() {
        AppMethodBeat.i(251888);
        FinderCommentInfo finderCommentInfo = this.field_actionInfo.LAk;
        if (finderCommentInfo == null) {
            finderCommentInfo = new FinderCommentInfo();
        }
        p.g(finderCommentInfo, "field_actionInfo.comment…fo ?: FinderCommentInfo()");
        AppMethodBeat.o(251888);
        return finderCommentInfo;
    }

    public final void FB(long j2) {
        this.field_actionInfo.tuf = j2;
    }

    public final String getUsername() {
        AppMethodBeat.i(251889);
        String str = dyb().username;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.username?:\"\"");
        AppMethodBeat.o(251889);
        return str;
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(167033);
        p.h(str, "value");
        dyb().username = str;
        AppMethodBeat.o(167033);
    }

    public final String getNickname() {
        AppMethodBeat.i(251890);
        String str = dyb().nickname;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.nickname?:\"\"");
        AppMethodBeat.o(251890);
        return str;
    }

    public final String getContent() {
        AppMethodBeat.i(251891);
        String str = dyb().content;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.content?:\"\"");
        AppMethodBeat.o(251891);
        return str;
    }

    public final String dyc() {
        AppMethodBeat.i(251892);
        String str = dyb().headUrl;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.headUrl?:\"\"");
        AppMethodBeat.o(251892);
        return str;
    }

    public final void avC(String str) {
        AppMethodBeat.i(167034);
        p.h(str, "value");
        dyb().headUrl = str;
        AppMethodBeat.o(167034);
    }

    public final void FC(long j2) {
        AppMethodBeat.i(251893);
        dyb().createtime = j2;
        AppMethodBeat.o(251893);
    }

    public final String dyd() {
        AppMethodBeat.i(251894);
        String str = dyb().replyNickname;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.replyNickname?:\"\"");
        AppMethodBeat.o(251894);
        return str;
    }

    public final void setLikeCount(int i2) {
        AppMethodBeat.i(251895);
        dyb().likeCount = i2;
        AppMethodBeat.o(251895);
    }

    public final void La(int i2) {
        AppMethodBeat.i(251896);
        dyb().expandCommentCount = i2;
        AppMethodBeat.o(251896);
    }

    public final void Lb(int i2) {
        AppMethodBeat.i(251897);
        dyb().displayFlag = i2;
        AppMethodBeat.o(251897);
    }

    public final String dye() {
        AppMethodBeat.i(251898);
        String str = dyb().reply_content;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.reply_content?:\"\"");
        AppMethodBeat.o(251898);
        return str;
    }

    public final String dyf() {
        AppMethodBeat.i(251899);
        String str = dyb().reply_username;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.reply_username?:\"\"");
        AppMethodBeat.o(251899);
        return str;
    }

    public final String dyg() {
        AppMethodBeat.i(251900);
        String str = dyb().client_id;
        if (str == null) {
            str = "";
        }
        p.g(str, "commentInfo.client_id?:\"\"");
        AppMethodBeat.o(251900);
        return str;
    }

    public final String getObjectNonceId() {
        String str = this.field_objectNonceId;
        return str == null ? "" : str;
    }

    public final boolean dyi() {
        return (this.field_state == 1 || this.field_state == -1) ? false : true;
    }

    public final boolean dyj() {
        AppMethodBeat.i(178419);
        y yVar = y.vXH;
        boolean LG = y.LG(dyb().displayFlag);
        AppMethodBeat.o(178419);
        return LG;
    }

    public final boolean dyk() {
        AppMethodBeat.i(178420);
        y yVar = y.vXH;
        boolean LH = y.LH(dyb().displayFlag);
        AppMethodBeat.o(178420);
        return LH;
    }

    public final String toString() {
        Object[] objArr;
        String str;
        Object[] objArr2;
        String str2;
        AppMethodBeat.i(167035);
        ae aeVar = ae.SYK;
        StringBuilder append = new StringBuilder("field_commentInfo{commentId:").append(dyb().commentId).append(", displayid:");
        FinderCommentInfo dyb = dyb();
        String sb = append.append((dyb != null ? Long.valueOf(dyb.displayid) : null).longValue()).append(" try_count ").append(this.field_tryCount).append(" conetent:%s}").toString();
        Object[] objArr3 = new Object[1];
        FinderCommentInfo dyb2 = dyb();
        if (!(dyb2 == null || (str2 = dyb2.content) == null)) {
            p.g(str2, LocaleUtil.ITALIAN);
            int min = Math.min(str2.length(), 2);
            if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(167035);
                throw tVar;
            }
            String substring = str2.substring(0, min);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring != null) {
                str = substring;
                objArr = objArr3;
                objArr2 = objArr3;
                objArr[0] = str;
                String format = String.format(sb, Arrays.copyOf(objArr2, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                AppMethodBeat.o(167035);
                return format;
            }
        }
        objArr2 = objArr3;
        str = "";
        objArr = objArr3;
        objArr[0] = str;
        String format2 = String.format(sb, Arrays.copyOf(objArr2, 1));
        p.g(format2, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(167035);
        return format2;
    }

    public final boolean dyh() {
        AppMethodBeat.i(251901);
        if ((dyb().extFlag & 1) > 0) {
            AppMethodBeat.o(251901);
            return true;
        }
        AppMethodBeat.o(251901);
        return false;
    }

    public final boolean dyl() {
        AppMethodBeat.i(178421);
        if ((dyb().displayFlag & 4) != 0) {
            AppMethodBeat.o(178421);
            return true;
        }
        AppMethodBeat.o(178421);
        return false;
    }
}
