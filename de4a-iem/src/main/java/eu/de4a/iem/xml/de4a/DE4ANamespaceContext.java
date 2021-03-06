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

import com.helger.commons.annotation.Singleton;
import com.helger.ubl23.UBL23NamespaceContext;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * XML Namespace context for DE4A
 *
 * @author Philip Helger
 */
@Singleton
public class DE4ANamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final DE4ANamespaceContext s_aInstance = new DE4ANamespaceContext ();
  }

  protected DE4ANamespaceContext ()
  {
    addMappings (UBL23NamespaceContext.getInstance ());
    addMapping ("eilp", "http://eidas.europa.eu/attributes/legalperson");
    addMapping ("einp", "http://eidas.europa.eu/attributes/naturalperson");
    addMapping ("de4aid", "http://www.de4a.eu/2020/commons/identity/type");
    addMapping ("de4a", "http://www.de4a.eu/2020/commons/type");
  }

  @Nonnull
  public static DE4ANamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}
