package com.tencent.mm.media.widget.camerarecordview.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0002\t\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer;", "", "getRecordScene", "", "getResolutionLimit", "initCameraConfig", "", "initFpsStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "CameraDeviceConfig", "Companion", "plugin-mediaeditor_release"})
public interface b {
    public static final C0437b iqZ = C0437b.irv;

    int getRecordScene();

    int getResolutionLimit();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$Companion;", "", "()V", "CAMERA_FOCUS_AUTO", "", "getCAMERA_FOCUS_AUTO", "()Ljava/lang/String;", "CAMERA_FOCUS_CONTINUS_PICUTRE", "getCAMERA_FOCUS_CONTINUS_PICUTRE", "CAMERA_FOCUS_CONTINUS_VIDEO", "getCAMERA_FOCUS_CONTINUS_VIDEO", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "", "getFOCUS_FACE_LOC_DIFF_THREASHOLD", "()I", "METER_FACE_LOC_DIFF_THRESHOLD", "getMETER_FACE_LOC_DIFF_THRESHOLD", "PREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "getPREVIEW_CALLBACK_FRONT_CAMERA_MIRROR", "PREVIEW_CALLBACK_REMOVE", "getPREVIEW_CALLBACK_REMOVE", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.d.b$b  reason: collision with other inner class name */
    public static final class C0437b {
        private static final String irn = irn;
        private static final String iro = iro;
        private static final String irp = irp;
        private static final int irq = 20;
        private static final int irs = 70;
        private static final String irt = irt;
        private static final String iru = iru;
        static final /* synthetic */ C0437b irv = new C0437b();

        static {
            AppMethodBeat.i(218909);
            AppMethodBeat.o(218909);
        }

        private C0437b() {
        }

        public static String aQA() {
            return irn;
        }

        public static String aQB() {
            return iro;
        }

        public static String aQC() {
            return irp;
        }

        public static String aQD() {
            return irt;
        }

        public static String aQE() {
            return iru;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0005%&'()Bµ\u0001\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006\u0012\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u0006\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\u0006\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u0010\u0012R6\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R6\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006*"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "", "sizeConfigStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "Lkotlin/collections/HashMap;", "focusModeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "scene", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashSet;I)V", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "getFormatConfigStrategy", "setFormatConfigStrategy", "getFpsConfigStrategy", "setFpsConfigStrategy", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "getScene", "()I", "setScene", "(I)V", "getSizeConfigStrategy", "setSizeConfigStrategy", "Builder", "FocusConfigItem", "FpsConfigItem", "PreviewFormatItem", "SizeConfigItem", "plugin-mediaeditor_release"})
    public static final class a {
        public HashMap<Integer, e> ira;
        public HashMap<Integer, C0436b> irb;
        public HashMap<Integer, c> irc;
        public HashMap<Integer, d> ird;
        public HashSet<String> ire;
        private int scene;

        public a(HashMap<Integer, e> hashMap, HashMap<Integer, C0436b> hashMap2, HashMap<Integer, c> hashMap3, HashMap<Integer, d> hashMap4, HashSet<String> hashSet, int i2) {
            p.h(hashMap, "sizeConfigStrategy");
            p.h(hashMap2, "focusModeStrategy");
            p.h(hashMap3, "fpsConfigStrategy");
            p.h(hashMap4, "formatConfigStrategy");
            p.h(hashSet, "previewConfigStrategy");
            AppMethodBeat.i(218908);
            this.ira = hashMap;
            this.irb = hashMap2;
            this.irc = hashMap3;
            this.ird = hashMap4;
            this.ire = hashSet;
            this.scene = i2;
            AppMethodBeat.o(218908);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "", "focusPriority", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getFocusPriority", "()Ljava/util/ArrayList;", "setFocusPriority", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-mediaeditor_release"})
        /* renamed from: com.tencent.mm.media.widget.camerarecordview.d.b$a$b  reason: collision with other inner class name */
        public static final class C0436b {
            public ArrayList<String> irf;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(218895);
                if (this == obj || ((obj instanceof C0436b) && p.j(this.irf, ((C0436b) obj).irf))) {
                    AppMethodBeat.o(218895);
                    return true;
                }
                AppMethodBeat.o(218895);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(218894);
                ArrayList<String> arrayList = this.irf;
                if (arrayList != null) {
                    int hashCode = arrayList.hashCode();
                    AppMethodBeat.o(218894);
                    return hashCode;
                }
                AppMethodBeat.o(218894);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(218893);
                String str = "FocusConfigItem(focusPriority=" + this.irf + ")";
                AppMethodBeat.o(218893);
                return str;
            }

            private C0436b() {
                this.irf = null;
            }

            public /* synthetic */ C0436b(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "", "lowerFps", "", "upperFps", "curFps", "useFixMode", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCurFps", "()Ljava/lang/Integer;", "setCurFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLowerFps", "setLowerFps", "getUpperFps", "setUpperFps", "getUseFixMode", "()Ljava/lang/Boolean;", "setUseFixMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-mediaeditor_release"})
        public static final class c {
            public Integer irg;
            public Integer irh;
            public Integer iri;
            public Boolean irj;

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
                if (kotlin.g.b.p.j(r3.irj, r4.irj) != false) goto L_0x0036;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 218899(0x35713, float:3.06743E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0036
                    boolean r0 = r4 instanceof com.tencent.mm.media.widget.camerarecordview.d.b.a.c
                    if (r0 == 0) goto L_0x003b
                    com.tencent.mm.media.widget.camerarecordview.d.b$a$c r4 = (com.tencent.mm.media.widget.camerarecordview.d.b.a.c) r4
                    java.lang.Integer r0 = r3.irg
                    java.lang.Integer r1 = r4.irg
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003b
                    java.lang.Integer r0 = r3.irh
                    java.lang.Integer r1 = r4.irh
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003b
                    java.lang.Integer r0 = r3.iri
                    java.lang.Integer r1 = r4.iri
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003b
                    java.lang.Boolean r0 = r3.irj
                    java.lang.Boolean r1 = r4.irj
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003b
                L_0x0036:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x003a:
                    return r0
                L_0x003b:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x003a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.camerarecordview.d.b.a.c.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(218898);
                Integer num = this.irg;
                int hashCode = (num != null ? num.hashCode() : 0) * 31;
                Integer num2 = this.irh;
                int hashCode2 = ((num2 != null ? num2.hashCode() : 0) + hashCode) * 31;
                Integer num3 = this.iri;
                int hashCode3 = ((num3 != null ? num3.hashCode() : 0) + hashCode2) * 31;
                Boolean bool = this.irj;
                if (bool != null) {
                    i2 = bool.hashCode();
                }
                int i3 = hashCode3 + i2;
                AppMethodBeat.o(218898);
                return i3;
            }

            public final String toString() {
                AppMethodBeat.i(218897);
                String str = "FpsConfigItem(lowerFps=" + this.irg + ", upperFps=" + this.irh + ", curFps=" + this.iri + ", useFixMode=" + this.irj + ")";
                AppMethodBeat.o(218897);
                return str;
            }

            public /* synthetic */ c() {
                this(0, 0, 0);
                AppMethodBeat.i(218896);
                AppMethodBeat.o(218896);
            }

            private c(Integer num, Integer num2, Integer num3) {
                this.irg = num;
                this.irh = num2;
                this.iri = num3;
                this.irj = null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-mediaeditor_release"})
        public static final class e {
            public Integer irl;
            public Integer irm;

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
                if (kotlin.g.b.p.j(r3.irm, r4.irm) != false) goto L_0x0022;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 218907(0x3571b, float:3.06754E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0022
                    boolean r0 = r4 instanceof com.tencent.mm.media.widget.camerarecordview.d.b.a.e
                    if (r0 == 0) goto L_0x0027
                    com.tencent.mm.media.widget.camerarecordview.d.b$a$e r4 = (com.tencent.mm.media.widget.camerarecordview.d.b.a.e) r4
                    java.lang.Integer r0 = r3.irl
                    java.lang.Integer r1 = r4.irl
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0027
                    java.lang.Integer r0 = r3.irm
                    java.lang.Integer r1 = r4.irm
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0027
                L_0x0022:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0026:
                    return r0
                L_0x0027:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0026
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.camerarecordview.d.b.a.e.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(218906);
                Integer num = this.irl;
                int hashCode = (num != null ? num.hashCode() : 0) * 31;
                Integer num2 = this.irm;
                if (num2 != null) {
                    i2 = num2.hashCode();
                }
                int i3 = hashCode + i2;
                AppMethodBeat.o(218906);
                return i3;
            }

            public final String toString() {
                AppMethodBeat.i(218905);
                String str = "SizeConfigItem(width=" + this.irl + ", height=" + this.irm + ")";
                AppMethodBeat.o(218905);
                return str;
            }

            public /* synthetic */ e() {
                this(0, 0);
                AppMethodBeat.i(218904);
                AppMethodBeat.o(218904);
            }

            private e(Integer num, Integer num2) {
                this.irl = num;
                this.irm = num2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "", "format", "", "(Ljava/lang/Integer;)V", "getFormat", "()Ljava/lang/Integer;", "setFormat", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-mediaeditor_release"})
        public static final class d {
            public Integer irk;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(218903);
                if (this == obj || ((obj instanceof d) && p.j(this.irk, ((d) obj).irk))) {
                    AppMethodBeat.o(218903);
                    return true;
                }
                AppMethodBeat.o(218903);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(218902);
                Integer num = this.irk;
                if (num != null) {
                    int hashCode = num.hashCode();
                    AppMethodBeat.o(218902);
                    return hashCode;
                }
                AppMethodBeat.o(218902);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(218901);
                String str = "PreviewFormatItem(format=" + this.irk + ")";
                AppMethodBeat.o(218901);
                return str;
            }

            public /* synthetic */ d() {
                this(0);
                AppMethodBeat.i(218900);
                AppMethodBeat.o(218900);
            }

            private d(Integer num) {
                this.irk = num;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J7\u0010%\u001a\u00020\u00002*\u0010&\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060(0'\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060(¢\u0006\u0002\u0010)J7\u0010*\u001a\u00020\u00002*\u0010&\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110(0'\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110(¢\u0006\u0002\u0010)J\u001f\u0010+\u001a\u00020\u00002\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160'\"\u00020\u0016¢\u0006\u0002\u0010,J7\u0010-\u001a\u00020\u00002*\u0010&\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0(0'\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0(¢\u0006\u0002\u0010)J7\u0010.\u001a\u00020\u00002*\u0010&\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0(0'\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0(¢\u0006\u0002\u0010)J\u0006\u0010/\u001a\u000200J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR6\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R6\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000b¨\u00061"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "", "()V", "focusModeStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "Lkotlin/collections/HashMap;", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "getFormatConfigStrategy", "setFormatConfigStrategy", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "getFpsConfigStrategy", "setFpsConfigStrategy", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sizeConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "getSizeConfigStrategy", "setSizeConfigStrategy", "addFocusStrategy", "configs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addFpsConfigStrategy", "addPreviewCallbackConfigStrategy", "([Ljava/lang/String;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addPreviewFormatConfigStrategy", "addSizeConfigStrategy", "build", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "plugin-mediaeditor_release"})
        /* renamed from: com.tencent.mm.media.widget.camerarecordview.d.b$a$a  reason: collision with other inner class name */
        public static final class C0435a {
            private HashMap<Integer, e> ira = new HashMap<>();
            private HashMap<Integer, C0436b> irb = new HashMap<>();
            private HashMap<Integer, c> irc = new HashMap<>();
            private HashMap<Integer, d> ird = new HashMap<>();
            private HashSet<String> ire = new HashSet<>();
            public int scene = -1;

            public C0435a() {
                AppMethodBeat.i(218892);
                AppMethodBeat.o(218892);
            }

            public final C0435a a(o<Integer, C0436b>... oVarArr) {
                AppMethodBeat.i(218886);
                p.h(oVarArr, "configs");
                for (int i2 = 0; i2 <= 0; i2++) {
                    o<Integer, C0436b> oVar = oVarArr[0];
                    this.irb.put(oVar.first, oVar.second);
                }
                AppMethodBeat.o(218886);
                return this;
            }

            public final C0435a b(o<Integer, c>... oVarArr) {
                AppMethodBeat.i(218887);
                p.h(oVarArr, "configs");
                for (int i2 = 0; i2 <= 0; i2++) {
                    o<Integer, c> oVar = oVarArr[0];
                    this.irc.put(oVar.first, oVar.second);
                }
                AppMethodBeat.o(218887);
                return this;
            }

            public final C0435a c(o<Integer, e>... oVarArr) {
                AppMethodBeat.i(218888);
                p.h(oVarArr, "configs");
                for (int i2 = 0; i2 <= 0; i2++) {
                    o<Integer, e> oVar = oVarArr[0];
                    this.ira.put(oVar.first, oVar.second);
                }
                AppMethodBeat.o(218888);
                return this;
            }

            public final C0435a d(o<Integer, d>... oVarArr) {
                AppMethodBeat.i(218889);
                p.h(oVarArr, "configs");
                for (int i2 = 0; i2 <= 0; i2++) {
                    o<Integer, d> oVar = oVarArr[0];
                    this.ird.put(oVar.first, oVar.second);
                }
                AppMethodBeat.o(218889);
                return this;
            }

            public final C0435a j(String... strArr) {
                AppMethodBeat.i(218890);
                p.h(strArr, "configs");
                for (int i2 = 0; i2 <= 0; i2++) {
                    this.ire.add(strArr[0]);
                }
                AppMethodBeat.o(218890);
                return this;
            }

            public final a aQz() {
                AppMethodBeat.i(218891);
                a aVar = new a(this.ira, this.irb, this.irc, this.ird, this.ire, this.scene);
                AppMethodBeat.o(218891);
                return aVar;
            }
        }
    }
}
