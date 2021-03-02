package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class CMSampleBuffer {
    private ByteBuffer sampleByteBuffer;
    private final CMSampleState state;
    private TextureInfo texture;

    public CMSampleBuffer(CMSampleState cMSampleState) {
        AppMethodBeat.i(199391);
        this.state = cMSampleState;
        this.state.setNewFrame(false);
        this.texture = null;
        this.sampleByteBuffer = null;
        AppMethodBeat.o(199391);
    }

    public CMSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo) {
        this.state = cMSampleState;
        this.texture = textureInfo;
        this.sampleByteBuffer = null;
    }

    public CMSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo, boolean z) {
        AppMethodBeat.i(199392);
        this.state = cMSampleState;
        this.state.setNewFrame(z);
        this.texture = textureInfo;
        this.sampleByteBuffer = null;
        AppMethodBeat.o(199392);
    }

    public CMSampleBuffer(CMSampleState cMSampleState, ByteBuffer byteBuffer) {
        this.state = cMSampleState;
        this.sampleByteBuffer = byteBuffer;
        this.texture = null;
    }

    public CMSampleBuffer(CMSampleState cMSampleState, ByteBuffer byteBuffer, boolean z) {
        AppMethodBeat.i(199393);
        this.state = cMSampleState;
        this.state.setNewFrame(z);
        this.sampleByteBuffer = byteBuffer;
        this.texture = null;
        AppMethodBeat.o(199393);
    }

    public CMSampleBuffer(CMTime cMTime) {
        this(new CMSampleState(cMTime));
        AppMethodBeat.i(199394);
        AppMethodBeat.o(199394);
    }

    public CMSampleBuffer(CMTime cMTime, TextureInfo textureInfo) {
        this(new CMSampleState(cMTime), textureInfo);
        AppMethodBeat.i(199395);
        AppMethodBeat.o(199395);
    }

    public CMSampleBuffer(CMTime cMTime, TextureInfo textureInfo, boolean z) {
        this(new CMSampleState(cMTime), textureInfo, z);
        AppMethodBeat.i(199396);
        AppMethodBeat.o(199396);
    }

    public CMSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer) {
        this(new CMSampleState(cMTime), byteBuffer);
        AppMethodBeat.i(199397);
        AppMethodBeat.o(199397);
    }

    public CMSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer, boolean z) {
        this(new CMSampleState(cMTime), byteBuffer, z);
        AppMethodBeat.i(199398);
        AppMethodBeat.o(199398);
    }

    public CMSampleState getState() {
        return this.state;
    }

    public CMTime getTime() {
        AppMethodBeat.i(199399);
        CMTime time = this.state.getTime();
        AppMethodBeat.o(199399);
        return time;
    }

    public ByteBuffer getSampleByteBuffer() {
        return this.sampleByteBuffer;
    }

    public void setSampleByteBuffer(ByteBuffer byteBuffer) {
        this.sampleByteBuffer = byteBuffer;
    }

    public TextureInfo getTextureInfo() {
        return this.texture;
    }

    public boolean isNewFrame() {
        AppMethodBeat.i(199400);
        boolean isNewFrame = this.state.isNewFrame();
        AppMethodBeat.o(199400);
        return isNewFrame;
    }

    public void setNewFrame(boolean z) {
        AppMethodBeat.i(199401);
        this.state.setNewFrame(z);
        AppMethodBeat.o(199401);
    }

    public String toString() {
        AppMethodBeat.i(199402);
        String str = "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
        AppMethodBeat.o(199402);
        return str;
    }
}
