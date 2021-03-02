package com.tencent.tav.decoder.factory;

import com.tencent.tav.decoder.IVideoDecoder;

public interface IDecoderFactory {
    IVideoDecoder createVideoDecoder(int i2);
}
