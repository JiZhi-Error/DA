package com.tencent.mars.cdn;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByHostMatched;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public AndroidCertVerifyResult(int i2, boolean z, List<X509Certificate> list) {
        this.mStatus = i2;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = false;
    }

    public AndroidCertVerifyResult(int i2, boolean z, List<X509Certificate> list, boolean z2) {
        this.mStatus = i2;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = z2;
    }

    public AndroidCertVerifyResult(int i2) {
        this.mStatus = i2;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
        this.mIsIssuedByHostMatched = false;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }

    public boolean isIssuedByHostMatched() {
        return this.mIsIssuedByHostMatched;
    }

    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.mCertificateChain.size()][];
        for (int i2 = 0; i2 < this.mCertificateChain.size(); i2++) {
            try {
                bArr[i2] = this.mCertificateChain.get(i2).getEncoded();
            } catch (CertificateEncodingException e2) {
                return new byte[0][];
            }
        }
        return bArr;
    }
}
