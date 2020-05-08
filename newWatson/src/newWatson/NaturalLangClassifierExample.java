package newWatson;
/*
 * (C) Copyright IBM Corp. 2019.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyOptions;

public class NaturalLangClassifierExample {

  public static void main(String[] args) {
    Authenticator authenticator = new IamAuthenticator("CJmH1dY2eM63Cod-AFmOs-2ztA9VUI5pINay4Skt7QEd");
    NaturalLanguageClassifier service = new NaturalLanguageClassifier(authenticator);

    ClassifyOptions classifyOptions =
        new ClassifyOptions.Builder().classifierId("ServiceId-541f0f84-35c9-4a9b-818b-d63a8510ae56").text("Is it sunny?").build();
    Classification classification = service.classify(classifyOptions).execute().getResult();

    System.out.println(classification);
  }
}
