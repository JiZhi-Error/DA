package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/voip/model/VoipRenderIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markDestroySurfaceTexture", "", "markDestroySurfaceTextureFailedException", "markHardToSoftDecode", "markHardToSoftEncode", "markInitSurfaceTexture", "markInitSurfaceTextureFailed", "markInitSurfaceTextureFailedException", "markLocalSendDataSampleZero", "markNv21RenderDataInvalid", "markRemoteSoftDecSampleDataZero", "markSmallWindowCreate", "markSmallWindowUninit", "markSoftToHardDecode", "markSoftToHardEncode", "markSurfaceTextureAttachGLContext", "markSurfaceTextureAttachGLContextFailed", "markSurfaceTextureDetachGLContext", "markSurfaceTextureDetachGLContextFailed", "markVideoActivityOnCreate", "markVideoActivityOnDestroy", "markYv12RenderDataInvalid", "plugin-voip_release"})
public final class t {
    public static final t GYO = new t();

    static {
        AppMethodBeat.i(115959);
        AppMethodBeat.o(115959);
    }

    private t() {
    }

    public static void fHu() {
        AppMethodBeat.i(115938);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markVideoActivityOnCreate");
        h.INSTANCE.n(1060, 0, 1);
        AppMethodBeat.o(115938);
    }

    public static void fHv() {
        AppMethodBeat.i(115939);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markVideoActivityOnDestroy");
        h.INSTANCE.n(1060, 1, 1);
        AppMethodBeat.o(115939);
    }

    public static void fHw() {
        AppMethodBeat.i(115940);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markInitSurfaceTexture");
        h.INSTANCE.n(1060, 3, 1);
        AppMethodBeat.o(115940);
    }

    public static void fHx() {
        AppMethodBeat.i(115941);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markInitSurfaceTextureFailed");
        h.INSTANCE.n(1060, 4, 1);
        AppMethodBeat.o(115941);
    }

    public static void fHy() {
        AppMethodBeat.i(115942);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markInitSurfaceTextureFailedException");
        h.INSTANCE.n(1060, 5, 1);
        AppMethodBeat.o(115942);
    }

    public static void fHz() {
        AppMethodBeat.i(115943);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markDestroySurfaceTexture");
        h.INSTANCE.n(1060, 6, 1);
        AppMethodBeat.o(115943);
    }

    public static void fHA() {
        AppMethodBeat.i(115944);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markDestroySurfaceTextureFailedException");
        h.INSTANCE.n(1060, 7, 1);
        AppMethodBeat.o(115944);
    }

    public static void fHB() {
        AppMethodBeat.i(115945);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSurfaceTextureAttachGLContext");
        h.INSTANCE.n(1060, 10, 1);
        AppMethodBeat.o(115945);
    }

    public static void fHC() {
        AppMethodBeat.i(115946);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSurfaceTextureAttachGLContextFailed");
        h.INSTANCE.n(1060, 11, 1);
        AppMethodBeat.o(115946);
    }

    public static void fHD() {
        AppMethodBeat.i(115947);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSurfaceTextureDetachGLContext");
        h.INSTANCE.n(1060, 12, 1);
        AppMethodBeat.o(115947);
    }

    public static void fHE() {
        AppMethodBeat.i(115948);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSurfaceTextureDetachGLContextFailed");
        h.INSTANCE.n(1060, 13, 1);
        AppMethodBeat.o(115948);
    }

    public static void fHF() {
        AppMethodBeat.i(115949);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSoftToHardDecode");
        h.INSTANCE.n(1060, 15, 1);
        AppMethodBeat.o(115949);
    }

    public static void fHG() {
        AppMethodBeat.i(115950);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markHardToSoftDecode");
        h.INSTANCE.n(1060, 16, 1);
        AppMethodBeat.o(115950);
    }

    public static void fHH() {
        AppMethodBeat.i(115951);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSoftToHardEncode");
        h.INSTANCE.n(1060, 19, 1);
        AppMethodBeat.o(115951);
    }

    public static void fHI() {
        AppMethodBeat.i(115952);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markHardToSoftEncode");
        h.INSTANCE.n(1060, 20, 1);
        AppMethodBeat.o(115952);
    }

    public static void fHJ() {
        AppMethodBeat.i(115953);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSmallWindowCreate");
        h.INSTANCE.n(1060, 24, 1);
        AppMethodBeat.o(115953);
    }

    public static void fHK() {
        AppMethodBeat.i(115954);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markSmallWindowUninit");
        h.INSTANCE.n(1060, 25, 1);
        AppMethodBeat.o(115954);
    }

    public static void fHL() {
        AppMethodBeat.i(115955);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markNv21RenderDataInvalid");
        h.INSTANCE.n(1060, 28, 1);
        AppMethodBeat.o(115955);
    }

    public static void fHM() {
        AppMethodBeat.i(115956);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markYv12RenderDataInvalid");
        h.INSTANCE.n(1060, 29, 1);
        AppMethodBeat.o(115956);
    }

    public static void fHN() {
        AppMethodBeat.i(115957);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markRemoteSoftDecSampleDataZero");
        h.INSTANCE.n(1060, 31, 0);
        AppMethodBeat.o(115957);
    }

    public static void fHO() {
        AppMethodBeat.i(115958);
        Log.i("MicroMsg.VoipRenderIDKeyStat", "markLocalSendDataSampleZero");
        h.INSTANCE.n(1060, 32, 0);
        AppMethodBeat.o(115958);
    }
}
