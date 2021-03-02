package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher;

public interface l extends TXLivePusher.VideoCustomProcessListener {
    public static final l cGz = new l() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.AnonymousClass1 */

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final boolean isEnabled() {
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(a aVar, float f2) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void b(String str, float f2) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void clearFilters() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(c cVar, String str) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void Qf() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(b bVar, String str) {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void Qg() {
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final int onTextureCustomProcess(int i2, int i3, int i4) {
            return 0;
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final void onDetectFacePoints(float[] fArr) {
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final void onTextureDestoryed() {
        }
    };

    void Qf();

    void Qg();

    void a(a aVar, float f2);

    void a(b bVar, String str);

    void a(c cVar, String str);

    void b(String str, float f2);

    void clearFilters();

    boolean isEnabled();

    public enum a {
        SKIN_BRIGHT,
        SKIN_SMOOTH,
        FACE_THIN,
        EYE_BIGGER;

        public static a valueOf(String str) {
            AppMethodBeat.i(215627);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(215627);
            return aVar;
        }

        static {
            AppMethodBeat.i(215628);
            AppMethodBeat.o(215628);
        }
    }

    public enum c {
        STICKER_BACK,
        STICKER_FRONT,
        STICKER_2D;

        public static c valueOf(String str) {
            AppMethodBeat.i(215633);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(215633);
            return cVar;
        }

        static {
            AppMethodBeat.i(215634);
            AppMethodBeat.o(215634);
        }
    }

    public enum b {
        MAKEUP_LIP_STICK,
        MAKEUP_EYE_SHADOW,
        MAKEUP_BLUSHER_STICK,
        MAKEUP_FACE_CONTOUR,
        MAKEUP_EYE_BROW;

        public static b valueOf(String str) {
            AppMethodBeat.i(215630);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(215630);
            return bVar;
        }

        static {
            AppMethodBeat.i(215631);
            AppMethodBeat.o(215631);
        }
    }
}
