/*
 *  Copyright (C) 2010 Ryszard Wiśniewski <brut.alll@gmail.com>
 *  Copyright (C) 2010 Connor Tumbleson <connor.tumbleson@gmail.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package brut.androlib.decode;

import brut.androlib.ApkDecoder;
import brut.androlib.BaseTest;
import brut.androlib.Config;
import brut.androlib.TestUtils;
import brut.common.BrutException;
import brut.directory.ExtFile;

import org.junit.*;
import static org.junit.Assert.*;

public class ParentDirectoryTraversalTest extends BaseTest {
    private static final String apk = "issue1498.apk";

    @BeforeClass
    public static void beforeClass() throws Exception {
        TestUtils.copyResourceDir(ParentDirectoryTraversalTest.class, "decode/issue1498", sTmpDir);
    }

    @Test
    public void checkIfDrawableFileDecodesProperly() throws BrutException {
        sConfig.setForceDelete(true);
        sConfig.setDecodeResources(Config.DECODE_RESOURCES_NONE);

        ExtFile testApk = new ExtFile(sTmpDir, apk);
        ExtFile testDir = new ExtFile(testApk + ".out");
        new ApkDecoder(testApk, sConfig).decode(testDir);
    }
}
