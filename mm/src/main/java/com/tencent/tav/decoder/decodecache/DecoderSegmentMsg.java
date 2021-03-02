package com.tencent.tav.decoder.decodecache;

/* access modifiers changed from: package-private */
public class DecoderSegmentMsg {
    final RequestStatus callbackObject;
    final CacheSegment segment;

    DecoderSegmentMsg(CacheSegment cacheSegment, RequestStatus requestStatus) {
        this.segment = cacheSegment;
        this.callbackObject = requestStatus;
    }
}
