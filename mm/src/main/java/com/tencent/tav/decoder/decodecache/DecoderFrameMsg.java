package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMTime;
import java.util.concurrent.CountDownLatch;

/* access modifiers changed from: package-private */
public class DecoderFrameMsg {
    final CountDownLatch finishWait;
    final CMTime time;

    DecoderFrameMsg(CMTime cMTime, CountDownLatch countDownLatch) {
        this.time = cMTime;
        this.finishWait = countDownLatch;
    }
}
