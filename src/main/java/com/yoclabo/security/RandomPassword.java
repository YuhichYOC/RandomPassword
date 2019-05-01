/*
 *
 * RandomPassword.java
 *
 * Copyright 2019 Yuichi Yoshii
 *     吉井雄一 @ 吉井産業  you.65535.kir@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.yoclabo.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomPassword {

    public static String get(int length) throws NoSuchAlgorithmException {
        SecureRandom r = SecureRandom.getInstance("SHA1PRNG");
        int d = 0;
        char[] ret = new char[length];
        do {
            char add = nextChar(r);
            if (((char) 20) == add) {
                continue;
            }
            ret[d] = add;
            ++d;
        } while (d < length);
        return String.valueOf(ret);
    }

    private static char nextChar(SecureRandom r) {
        int c = r.nextInt(123);
        // 0 - 9 ... 48 - 57
        // A - Z ... 65 - 90
        // a - z ... 97 - 122
        if (47 < c && c < 58) {
            return Character.toChars(c)[0];
        }
        else if (64 < c && c < 91) {
            return Character.toChars(c)[0];
        }
        else if (96 < c && c < 123) {
            return Character.toChars(c)[0];
        }
        return (char) 20;
    }
}
