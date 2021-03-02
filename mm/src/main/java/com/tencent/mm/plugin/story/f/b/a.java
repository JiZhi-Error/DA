package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edg;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0002\u0010\tB\u0005¢\u0006\u0002\u0010\nJ\b\u0010H\u001a\u00020\u0015H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010'\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010)\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001a\u00100\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u00103\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R\u001a\u00106\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R\u001a\u00109\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R\u001c\u0010B\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019R\u001a\u0010E\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;)V", "commentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "(Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;)V", "storyCommentItem", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "commentId", "getCommentId", "setCommentId", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "fromUser", "getFromUser", "setFromUser", "isBubble", "", "()Z", "setBubble", "(Z)V", "isEnhance", "setEnhance", "isSelf", "setSelf", "isStoryDeprecated", "setStoryDeprecated", "isUnread", "setUnread", ch.COL_LOCALID, "getLocalId", "setLocalId", "needShake", "getNeedShake", "setNeedShake", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "state", "getState", "setState", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "thumbUrl", "getThumbUrl", "setThumbUrl", "toUser", "getToUser", "setToUser", "toString", "plugin-story_release"})
public final class a {
    public int FnS;
    public boolean FnW;
    public boolean FnX;
    public boolean FnY;
    public boolean FnZ;
    String Foa;
    public int Fob;
    public boolean Foc;
    private int color;
    public String content;
    private boolean dJM;
    private String dJX;
    public String dRL;
    public long edx;
    public int iXu;
    private int state;
    private String thumbUrl;
    public String toUser;

    public a() {
        this.dRL = "";
        this.content = "";
        this.dJX = "";
        this.color = -1;
        this.toUser = "";
        this.Foa = "";
    }

    public final void aSd(String str) {
        AppMethodBeat.i(118844);
        p.h(str, "<set-?>");
        this.Foa = str;
        AppMethodBeat.o(118844);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(edf edf) {
        this();
        boolean z;
        boolean z2 = true;
        p.h(edf, "commentDetail");
        AppMethodBeat.i(118846);
        this.edx = edf.Id;
        this.iXu = edf.CreateTime;
        this.FnS = edf.MYT;
        String str = edf.xNH;
        this.dRL = str == null ? "" : str;
        String str2 = edf.iAc;
        this.content = str2 == null ? "" : str2;
        String str3 = edf.iAc;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.FnX = z;
        this.FnZ = edf.NdD != 1 ? false : z2;
        String str4 = edf.xNG;
        this.toUser = str4 == null ? "" : str4;
        this.Fob = edf.MYS;
        AppMethodBeat.o(118846);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(edg edg) {
        this();
        boolean z;
        p.h(edg, "commentOp");
        AppMethodBeat.i(118847);
        this.edx = edg.edx;
        String str = edg.dRL;
        this.dRL = str == null ? "" : str;
        String str2 = edg.content;
        this.content = str2 == null ? "" : str2;
        this.iXu = edg.iXu;
        String str3 = edg.content;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.FnX = z;
        String str4 = edg.toUser;
        this.toUser = str4 == null ? "" : str4;
        String str5 = edg.Foa;
        this.Foa = str5 == null ? "" : str5;
        this.Fob = edg.Fob;
        this.Foc = false;
        AppMethodBeat.o(118847);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this();
        p.h(aVar, "storyCommentItem");
        AppMethodBeat.i(118848);
        this.dJM = aVar.dJM;
        this.dRL = aVar.dRL;
        this.content = aVar.content;
        this.iXu = aVar.iXu;
        this.edx = aVar.edx;
        this.thumbUrl = aVar.thumbUrl;
        this.FnS = aVar.FnS;
        this.dJX = aVar.dJX;
        this.FnW = aVar.FnW;
        this.color = aVar.color;
        this.state = aVar.state;
        this.FnX = aVar.FnX;
        this.FnY = aVar.FnY;
        this.FnZ = aVar.FnZ;
        this.toUser = aVar.toUser;
        this.Foa = aVar.Foa;
        this.Fob = aVar.Fob;
        this.Foc = aVar.Foc;
        AppMethodBeat.o(118848);
    }

    public final String toString() {
        AppMethodBeat.i(118845);
        String str = "StoryCommentItem(fromUser='" + this.dRL + "', content='" + this.content + "', createTime=" + this.iXu + ", commentId=" + this.FnS + ", isUnread=" + this.FnW + " )";
        AppMethodBeat.o(118845);
        return str;
    }
}
