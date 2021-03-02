package com.tencent.mm.plugin.story.c.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "()V", "canShowConfig", "", "type", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "enableBlurMouth", "enableFavorite", "enableFavoriteByStatus", "enableImage2Video", "enableLyrics", "enableMusic", "enableReply", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getEasterEggRegex", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "getFavExpiredTime", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "StoryBasicConfig", "plugin-story_release"})
public final class a extends b<C1744a> implements f {
    public static final a FkW = new a();

    static {
        AppMethodBeat.i(118580);
        AppMethodBeat.o(118580);
    }

    private a() {
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        AppMethodBeat.i(118576);
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118576);
            return;
        }
        cav();
        AppMethodBeat.o(118576);
    }

    @Override // com.tencent.mm.media.b.c
    public final void cav() {
        boolean z;
        boolean z2;
        C1744a aVar;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = true;
        AppMethodBeat.i(259986);
        ((C1744a) aLQ()).FkX.clear();
        if (ab("SnsTimelineLikeCommentStoryBubbleSwitch", 1) == 1) {
            ((C1744a) aLQ()).FkX.add(f.a.TimeLine_Like);
        }
        ab("SnsTimelineJumpStorySwitch", 0);
        k.a.KqS = Pattern.compile(((C1744a) aLQ()).regex);
        C1744a aVar2 = (C1744a) aLQ();
        if (ab("StoryEditVideoBgmSwitch", 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar2.BNX = z;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
        ((C1744a) aLQ()).BNY = fromDPToPix * 100;
        ((C1744a) aLQ()).BNZ = fromDPToPix * 100;
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            ((C1744a) aLQ()).BNM = true;
            ((C1744a) aLQ()).BNN = true;
            ((C1744a) aLQ()).BNO = true;
            ((C1744a) aLQ()).BNR = true;
            ((C1744a) aLQ()).BNQ = true;
            aVar = (C1744a) aLQ();
            z2 = true;
        } else {
            C1744a aVar3 = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_favorite_enable, 0) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar3.BNM = z4;
            C1744a aVar4 = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_notify_sns_enable, 0) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            aVar4.BNN = z5;
            C1744a aVar5 = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_reply_enable, 0) == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            aVar5.BNO = z6;
            C1744a aVar6 = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_image_2_video_enable, 1) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            aVar6.BNR = z7;
            C1744a aVar7 = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_edit_tip_enable, 1) == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            aVar7.BNQ = z8;
            aVar = (C1744a) aLQ();
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_big_mouth_blur_enable, 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        aVar.BNT = z2;
        ((C1744a) aLQ()).BNU = ab("StoryFeaturedExpiredTime", 15552000);
        ((C1744a) aLQ()).BNV = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_album_duration, 10);
        C1744a aVar8 = (C1744a) aLQ();
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_edit_lyrics_enable, 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        aVar8.BNP = z3;
        C1744a aVar9 = (C1744a) aLQ();
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_add_music_enable, 1) != 1) {
            z9 = false;
        }
        aVar9.BNS = z9;
        AppMethodBeat.o(259986);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J1\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u000200HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u0014\u0010/\u001a\u000200XD¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020908¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryBasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "regex", "", "getRegex", "()Ljava/lang/String;", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "showSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig$SnsPositionType;", "getShowSet", "()Ljava/util/HashSet;", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.c.a.a$a  reason: collision with other inner class name */
    public static final class C1744a {
        boolean BNM;
        public boolean BNN;
        boolean BNO;
        boolean BNP;
        boolean BNQ;
        boolean BNR;
        boolean BNS;
        public boolean BNT;
        int BNU;
        int BNV;
        private int BNW;
        boolean BNX;
        public int BNY;
        public int BNZ;
        final HashSet<f.a> FkX;
        final String regex;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C1744a) {
                    C1744a aVar = (C1744a) obj;
                    if (!(this.BNW == aVar.BNW && this.BNX == aVar.BNX && this.BNY == aVar.BNY && this.BNZ == aVar.BNZ)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = this.BNW * 31;
            boolean z = this.BNX;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return ((((i3 + i2) * 31) + this.BNY) * 31) + this.BNZ;
        }

        public final String toString() {
            AppMethodBeat.i(118574);
            String str = "StoryBasicConfig(repeatMD5=" + this.BNW + ", showMusicIcon=" + this.BNX + ", albumThumbHeight=" + this.BNY + ", albumThumbWidth=" + this.BNZ + ")";
            AppMethodBeat.o(118574);
            return str;
        }

        private C1744a() {
            AppMethodBeat.i(118573);
            this.BNW = 2;
            this.BNX = true;
            this.BNY = 0;
            this.BNZ = 0;
            this.FkX = new HashSet<>();
            this.regex = "#冒泡#";
            this.BNS = true;
            this.BNU = 15552000;
            this.BNV = 10;
            AppMethodBeat.o(118573);
        }

        public /* synthetic */ C1744a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.story.api.f
    public final synchronized boolean a(f.a aVar) {
        boolean a2;
        AppMethodBeat.i(118577);
        a2 = j.a(((C1744a) aLT()).FkX, aVar);
        AppMethodBeat.o(118577);
        return a2;
    }

    @Override // com.tencent.mm.plugin.story.api.f
    public final boolean fnd() {
        AppMethodBeat.i(118578);
        boolean z = ((C1744a) aLT()).BNM;
        AppMethodBeat.o(118578);
        return z;
    }

    public final boolean hWO() {
        AppMethodBeat.i(259987);
        boolean z = ((C1744a) caF()).BNM;
        AppMethodBeat.o(259987);
        return z;
    }

    public final boolean fnu() {
        AppMethodBeat.i(118579);
        boolean z = ((C1744a) aLT()).BNO;
        AppMethodBeat.o(118579);
        return z;
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(118575);
        C1744a aVar = new C1744a((byte) 0);
        AppMethodBeat.o(118575);
        return aVar;
    }
}
