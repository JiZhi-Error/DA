package com.tencent.mm.plugin.story.f.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00105\u001a\u00020\u0003H\u0016J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202J\b\u0010:\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "", ch.COL_LOCALID, "", "storyId", "", "createTime", ch.COL_USERNAME, "", "(IJILjava/lang/String;)V", "getCreateTime", "()I", "setCreateTime", "(I)V", "fakeVideoData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "getFakeVideoData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setFakeVideoData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getLocalId", "setLocalId", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", m.NAME, "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getStoryId", "()J", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "videoType", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "getVideoType", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "setVideoType", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;)V", "canPlay", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "isFakeVideo", "isImageVideo", "isNormalVideo", "isVLogFakeVideo", "toString", "plugin-story_release"})
public final class j {
    dlg BKf;
    public k Fpc = k.Normal;
    public edt Fpd;
    public c Fpe;
    public int ecf;
    public final long edx;
    public int iXu;
    public String taskId;
    public String username;

    public j(int i2, long j2, int i3, String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(118941);
        this.ecf = i2;
        this.edx = j2;
        this.iXu = i3;
        this.username = str;
        edt edt = new edt();
        edt.Url = "";
        edt.Msz = "";
        edt.Id = "";
        this.Fpd = edt;
        this.taskId = "";
        AppMethodBeat.o(118941);
    }

    private boolean foU() {
        return this.Fpc == k.Normal;
    }

    public final boolean foV() {
        return this.Fpc == k.Fake;
    }

    public final boolean foW() {
        return this.Fpc != k.Empty;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118936);
        if (!(obj instanceof j)) {
            AppMethodBeat.o(118936);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(118936);
            return true;
        } else if (this.Fpc == k.Empty && ((j) obj).Fpc == k.Empty) {
            AppMethodBeat.o(118936);
            return true;
        } else if (foV() && ((j) obj).foV() && Util.isEqual(this.taskId, ((j) obj).taskId)) {
            AppMethodBeat.o(118936);
            return true;
        } else if (!foU() || !((j) obj).foU() || this.ecf != ((j) obj).ecf) {
            AppMethodBeat.o(118936);
            return false;
        } else {
            AppMethodBeat.o(118936);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(118937);
        int hashCode = super.hashCode();
        AppMethodBeat.o(118937);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(118938);
        String str = "[VideoItem=" + hashCode() + ",localId=:" + this.ecf + ",storyId=" + this.edx + ",videoType:=" + this.Fpc + ", username=" + this.username + ", url=" + this.Fpd.Url + ']';
        AppMethodBeat.o(118938);
        return str;
    }

    public final boolean foX() {
        c cVar;
        LinkedList<String> linkedList;
        AppMethodBeat.i(118939);
        if (!foV() || (cVar = this.Fpe) == null || (linkedList = cVar.eII().Lsc) == null || linkedList.size() <= 0) {
            AppMethodBeat.o(118939);
            return false;
        }
        Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake imageVideo");
        AppMethodBeat.o(118939);
        return true;
    }

    public final boolean foY() {
        byte[] bArr;
        epc epc;
        AppMethodBeat.i(118940);
        if (foV()) {
            aio aio = new aio();
            c cVar = this.Fpe;
            if (cVar != null) {
                bArr = cVar.field_baseItemData;
            } else {
                bArr = null;
            }
            try {
                aio.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                aio = null;
            }
            aio aio2 = aio;
            if (!(aio2 == null || aio2.Lsd == null)) {
                epc epc2 = new epc();
                try {
                    epc2.parseFrom(aio2.Lsd.toByteArray());
                    epc = epc2;
                } catch (Exception e3) {
                    Log.printDebugStack("safeParser", "", e3);
                    epc = null;
                }
                if (epc != null) {
                    Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is fake isVLogFakeVideo");
                    AppMethodBeat.o(118940);
                    return true;
                }
            }
        }
        Log.i("MicroMsg.Story.StoryVideoItem", "item" + this.taskId + " is not fake isVLogFakeVideo");
        AppMethodBeat.o(118940);
        return false;
    }
}
