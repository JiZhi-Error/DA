package com.tencent.qqmusic.mediaplayer.upstream;

public interface TransferListener {
    void onBytesTransferError(long j2, long j3, long j4);

    void onBytesTransferred(long j2, long j3);

    void onBytesTransferring(long j2, long j3);

    void onTransferEnd();

    void onTransferStart();
}
