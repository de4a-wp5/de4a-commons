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
package eu.de4a.iem.xml.de4a.t41.v2021_04_13;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Singleton;
import com.helger.ubl23.UBL23NamespaceContext;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * XML Namespace context for DE4A T4.1 v2021-04-13
 *
 * @author Philip Helger
 */
@Singleton
public class DE4AT41NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final DE4AT41NamespaceContext INSTANCE = new DE4AT41NamespaceContext ();
  }

  protected DE4AT41NamespaceContext ()
  {
    addMappings (UBL23NamespaceContext.getInstance ());
    addMapping ("eup", "http://data.europa.eu/europass/model/credentials#");
    addMapping ("cred", "http://data.europa.eu/europass/model/credentials/w3c#");
    addMapping ("sa", CT41.NAMESPACE_URI);
  }

  @Nonnull
  public static DE4AT41NamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
