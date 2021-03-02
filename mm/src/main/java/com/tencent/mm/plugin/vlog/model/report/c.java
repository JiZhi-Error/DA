package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0006\u0017\u0018\u0019\u001a\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"})
public final class c extends com.tencent.mm.sticker.a {
    C1850c GBc = new C1850c();
    ArrayList<a> editList = new ArrayList<>();
    ArrayList<e> tGk = new ArrayList<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"})
    public static final class d extends e {
    }

    public c() {
        AppMethodBeat.i(190826);
        AppMethodBeat.o(190826);
    }

    @Override // com.tencent.mm.sticker.a
    public final JSONObject toJson() {
        AppMethodBeat.i(190825);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this.GBc.toJson());
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.tGk.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        jSONObject.put("mediaList", jSONArray);
        if (!this.editList.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<T> it2 = this.editList.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().toJson());
            }
            jSONObject.put("editList", jSONArray2);
        }
        AppMethodBeat.o(190825);
        return jSONObject;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.model.report.c$c  reason: collision with other inner class name */
    public static final class C1850c extends com.tencent.mm.sticker.a {
        int GBe;
        int GBf;
        int GBg;

        @Override // com.tencent.mm.sticker.a
        public final JSONObject toJson() {
            AppMethodBeat.i(190821);
            JSONObject json = super.toJson();
            json.put("pss", new StringBuilder().append(this.GBe).append('K').toString());
            json.put("thumbCount", this.GBf);
            json.put("thumbMem", Util.getSizeMB((long) this.GBg));
            AppMethodBeat.o(190821);
            return json;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
    public static class e extends com.tencent.mm.sticker.a {
        ArrayList<Long> GBd = new ArrayList<>();
        ArrayList<Integer> GBh = new ArrayList<>();
        int type;

        public e() {
            AppMethodBeat.i(190823);
            AppMethodBeat.o(190823);
        }

        @Override // com.tencent.mm.sticker.a
        public JSONObject toJson() {
            AppMethodBeat.i(190822);
            JSONObject json = super.toJson();
            json.put("type", this.type);
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = this.GBh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().intValue());
            }
            json.put("size", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<T> it2 = this.GBd.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().longValue());
            }
            json.put("time", jSONArray2);
            AppMethodBeat.o(190822);
            return json;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "getBitrate", "setBitrate", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
    public static final class f extends e {
        int audioBitrate;
        int audioSampleRate;
        int bitrate = 1;
        float cKu = 1.0f;
        float mwH = 1.0f;

        @Override // com.tencent.mm.plugin.vlog.model.report.c.e, com.tencent.mm.sticker.a
        public final JSONObject toJson() {
            AppMethodBeat.i(190824);
            JSONObject json = super.toJson();
            if (this.mwH != 1.0f) {
                json.put("playRate", Float.valueOf(this.mwH));
            }
            json.put("fps", Float.valueOf(this.cKu));
            json.put(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
            json.put("audioSampleRate", this.audioSampleRate);
            json.put("audioBitrate", this.audioBitrate);
            AppMethodBeat.o(190824);
            return json;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
    public static class a extends com.tencent.mm.sticker.a {
        ArrayList<Long> GBd = new ArrayList<>();
        int type;

        public a() {
            AppMethodBeat.i(190818);
            AppMethodBeat.o(190818);
        }

        @Override // com.tencent.mm.sticker.a
        public JSONObject toJson() {
            AppMethodBeat.i(190817);
            JSONObject json = super.toJson();
            json.put("type", this.type);
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = this.GBd.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            json.put("time", jSONArray);
            AppMethodBeat.o(190817);
            return json;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
    public static final class b extends a {
        private String CeI = "";

        public final void setFont(String str) {
            AppMethodBeat.i(190819);
            p.h(str, "<set-?>");
            this.CeI = str;
            AppMethodBeat.o(190819);
        }

        @Override // com.tencent.mm.plugin.vlog.model.report.c.a, com.tencent.mm.sticker.a
        public final JSONObject toJson() {
            AppMethodBeat.i(190820);
            JSONObject json = super.toJson();
            if (!Util.isNullOrNil(this.CeI)) {
                json.put("font", this.CeI);
            }
            AppMethodBeat.o(190820);
            return json;
        }
    }
}
