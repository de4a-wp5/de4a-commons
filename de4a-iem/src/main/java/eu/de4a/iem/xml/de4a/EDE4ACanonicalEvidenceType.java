/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.de4a.iem.xml.de4a;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;

/**
 * Contains all the predefined DE4A Canonical Evidences
 *
 * @author Philip Helger
 */
public enum EDE4ACanonicalEvidenceType implements IDE4ACanonicalEvidenceType
{
  T41_UC1_2021_02_11 ("T4.1 UC1 v2021-02-11", eu.de4a.iem.xml.de4a.t41.v2021_02_11.CT41.getAllXSDs ()),
  T41_UC1_2021_04_13 ("T4.1 UC1 v2021-04-13", eu.de4a.iem.xml.de4a.t41.v2021_04_13.CT41.getAllXSDs ()),
  T42_COMPANY_INFO_V06 ("T4.2 Company Info v0.6", eu.de4a.iem.xml.de4a.t42.v0_6.CT42.getAllXSDs ()),
  T43_BIRTH_EVIDENCE_V16 ("T4.3 Birth Evidence v1.6", eu.de4a.iem.xml.de4a.t43.v1_6.CT43.getAllBirthEvidenceXSDs ()),
  T43_DOMREG_EVIDENCE_V16 ("T4.3 Domicile Registration Evidence v1.6",
                           eu.de4a.iem.xml.de4a.t43.v1_6.CT43.getAllDomicileRegistrationEvidenceXSDs ()),
  T43_MARRIAGE_EVIDENCE_V16 ("T4.3 Marriage Evidence v1.6", eu.de4a.iem.xml.de4a.t43.v1_6.CT43.getAllMarriageEvidenceXSDs ());

  private final String m_sDisplayName;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EDE4ACanonicalEvidenceType (@Nonnull @Nonempty final String sDisplayName, @Nonnull final ICommonsList <ClassPathResource> aXSDs)
  {
    m_sDisplayName = sDisplayName;
    m_aXSDs = aXSDs;
  }

  @Nonnull
  @Nonempty
  public String getDisplayName ()
  {
    return m_sDisplayName;
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICommonsList <? extends ClassPathResource> getAllXSDs ()
  {
    return m_aXSDs;
  }
}
