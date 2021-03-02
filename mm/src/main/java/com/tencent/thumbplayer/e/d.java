package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.g;
import java.util.Map;

public final class d implements ITPPreloadProxy.IPreloadListener, ITPPlayListener {
    private String tag;

    public d(String str) {
        this.tag = str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
        AppMethodBeat.i(189205);
        g.i(this.tag, " empty proxy player listener , notify , onPlayProgress, current : " + j2 + ", total : " + j3);
        AppMethodBeat.o(189205);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadFinish() {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadError(int i2, int i3, String str) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlUpdate(String str) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadStatusUpdate(int i2) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadProtocolUpdate(String str, String str2) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final void onDownloadCdnUrlExpired(Map<String, String> map) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(189206);
        g.i(this.tag, " empty proxy player listener , notify , onPlayCallback, messageType : " + i2 + ",ext1:" + obj + ",ext2:" + obj2 + ",ext3" + obj3 + ",ext4" + obj4);
        AppMethodBeat.o(189206);
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getPlayerBufferLength() {
        AppMethodBeat.i(189207);
        g.i(this.tag, " empty proxy player listener , notify , getPlayerBufferLength");
        AppMethodBeat.o(189207);
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getCurrentPosition() {
        AppMethodBeat.i(189208);
        g.i(this.tag, " empty proxy player listener , notify , getCurrentPosition");
        AppMethodBeat.o(189208);
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int getCurrentPlayClipNo() {
        AppMethodBeat.i(189209);
        g.i(this.tag, " empty proxy player listener , notify , getCurrentPlayClipNo");
        AppMethodBeat.o(189209);
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getAdvRemainTime() {
        AppMethodBeat.i(189210);
        g.i(this.tag, " empty proxy player listener , notify , getAdvRemainTime");
        AppMethodBeat.o(189210);
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object getPlayInfo(long j2) {
        AppMethodBeat.i(189211);
        g.i(this.tag, " empty proxy player listener , notify , getPlayInfo with type : ".concat(String.valueOf(j2)));
        AppMethodBeat.o(189211);
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final Object getPlayInfo(String str) {
        AppMethodBeat.i(189212);
        g.i(this.tag, " empty proxy player listener , notify , getPlayInfo with key : ".concat(String.valueOf(str)));
        AppMethodBeat.o(189212);
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onStartReadData(int i2, String str, long j2, long j3) {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onReadData(int i2, String str, long j2, long j3) {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final int onStopReadData(int i2, String str, int i3) {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final long getDataTotalSize(int i2, String str) {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final String getDataFilePath(int i2, String str) {
        return null;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
    public final String getContentType(int i2, String str) {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener
    public final void onPrepareSuccess() {
        AppMethodBeat.i(189213);
        g.i(this.tag, " empty proxy player listener , notify , onPrepareSuccess : ");
        AppMethodBeat.o(189213);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener
    public final void onPrepareError() {
        AppMethodBeat.i(189214);
        g.i(this.tag, " empty proxy player listener , notify , onPrepareError : ");
        AppMethodBeat.o(189214);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener
    public final void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3) {
    }
}
