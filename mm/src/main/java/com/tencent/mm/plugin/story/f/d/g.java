package com.tencent.mm.plugin.story.f.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.b.a;
import java.util.LinkedList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00101\u001a\u00020\u0011H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u001a\u0010!\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "", "()V", "bubbleList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getBubbleList", "()Ljava/util/LinkedList;", "commentList", "getCommentList", "commentType", "", "getCommentType", "()I", "setCommentType", "(I)V", "commentUser", "", "getCommentUser", "()Ljava/lang/String;", "setCommentUser", "(Ljava/lang/String;)V", "isCommentUnread", "", "()Z", "setCommentUnread", "(Z)V", "isUnread", "setUnread", "isVisitorUnread", "setVisitorUnread", "msgList", "getMsgList", "showIndicator", "getShowIndicator", "setShowIndicator", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "storyOwner", "getStoryOwner", "setStoryOwner", "visitorList", "getVisitorList", "equals", FacebookRequestErrorClassification.KEY_OTHER, "toString", "plugin-story_release"})
public final class g {
    int EBD;
    public boolean FnW;
    private String FoM;
    public boolean FoN;
    public boolean FoO;
    boolean FoP;
    public final LinkedList<a> FoQ = new LinkedList<>();
    final LinkedList<a> FoR = new LinkedList<>();
    public final LinkedList<a> FoS = new LinkedList<>();
    public String Foa = "";
    public final LinkedList<a> commentList = new LinkedList<>();
    public long edx;

    public g() {
        AppMethodBeat.i(118918);
        AppMethodBeat.o(118918);
    }

    public final String toString() {
        AppMethodBeat.i(118916);
        String str = "StoryGalleryComment(fromUser='" + this.Foa + "', storyId=" + this.edx + ", commentType=" + this.EBD + ", commentUser=" + this.FoM + ", isUnread=" + this.FoN + ", commentList=" + this.commentList + ')';
        AppMethodBeat.o(118916);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118917);
        if (!(obj instanceof g)) {
            AppMethodBeat.o(118917);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(118917);
            return true;
        } else if (this.edx == ((g) obj).edx && this.commentList.size() == ((g) obj).commentList.size() && this.FoN == ((g) obj).FoN && this.FnW == ((g) obj).FnW) {
            AppMethodBeat.o(118917);
            return true;
        } else {
            AppMethodBeat.o(118917);
            return false;
        }
    }
}
