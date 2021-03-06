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

import java.util.List;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.xml.bind.JAXBElement;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;

import eu.de4a.iem.jaxb.common.types.RequestExtractEvidenceIMType;
import eu.de4a.iem.jaxb.common.types.RequestExtractEvidenceUSIType;
import eu.de4a.iem.jaxb.common.types.RequestForwardEvidenceType;
import eu.de4a.iem.jaxb.common.types.RequestLookupRoutingInformationType;
import eu.de4a.iem.jaxb.common.types.RequestTransferEvidenceUSIDTType;
import eu.de4a.iem.jaxb.common.types.RequestTransferEvidenceUSIIMDRType;
import eu.de4a.iem.jaxb.common.types.RequestUserRedirectionType;
import eu.de4a.iem.jaxb.common.types.ResponseErrorType;
import eu.de4a.iem.jaxb.common.types.ResponseExtractEvidenceType;
import eu.de4a.iem.jaxb.common.types.ResponseLookupRoutingInformationType;
import eu.de4a.iem.jaxb.common.types.ResponseTransferEvidenceType;
import eu.de4a.iem.jaxb.common.types.ResponseUserRedirectionType;

/**
 * DE4A Marshaller factory for the core data format
 *
 * @author Philip Helger
 */
@Immutable
public class DE4AMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
{
  public DE4AMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                         @Nullable final List <? extends ClassPathResource> aXSDs,
                         @Nonnull final Function <? super JAXBTYPE, ? extends JAXBElement <JAXBTYPE>> aJAXBElementWrapper)
  {
    super (aType, aXSDs, aJAXBElementWrapper);
    setNamespaceContext (DE4ANamespaceContext.getInstance ());
  }

  /**
   * Enable formatted output. Syntactic sugar.
   *
   * @return this for chaining
   */
  @Nonnull
  public final DE4AMarshaller <JAXBTYPE> formatted ()
  {
    setFormattedOutput (true);
    return this;
  }

  @Nonnull
  @Nonempty
  private static ICommonsList <ClassPathResource> _getXSDs (@Nonnull final ClassPathResource aCoreXSD,
                                                            @Nullable final ICommonsList <? extends ClassPathResource> aCanonicalEvidenceXSDs)
  {
    final ICommonsList <ClassPathResource> ret = new CommonsArrayList <> ();
    ret.addAll (CDE4AJAXB.XSDS);
    ret.add (aCoreXSD);
    if (aCanonicalEvidenceXSDs != null)
      ret.addAll (aCanonicalEvidenceXSDs);
    return ret;
  }

  // Data Evaluator

  @Nonnull
  public static DE4AMarshaller <RequestForwardEvidenceType> deUsiRequestMarshaller (@Nonnull final IDE4ACanonicalEvidenceType aCanonicalEvidenceType)
  {
    return new DE4AMarshaller <> (RequestForwardEvidenceType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DE_USI, aCanonicalEvidenceType.getAllXSDs ()),
                                  new eu.de4a.iem.jaxb.de_usi.ObjectFactory ()::createRequestForwardEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseErrorType> deUsiResponseMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseErrorType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DE_USI, null),
                                  new eu.de4a.iem.jaxb.de_usi.ObjectFactory ()::createResponseForwardEvidence);
  }

  // Data Owner

  @Nonnull
  public static DE4AMarshaller <RequestExtractEvidenceIMType> doImRequestMarshaller ()
  {
    return new DE4AMarshaller <> (RequestExtractEvidenceIMType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DT_DO_IM, null),
                                  new eu.de4a.iem.jaxb.do_im.ObjectFactory ()::createRequestExtractEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseExtractEvidenceType> doImResponseMarshaller (@Nonnull final IDE4ACanonicalEvidenceType aCanonicalEvidenceType)
  {
    return new DE4AMarshaller <> (ResponseExtractEvidenceType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DT_DO_IM, aCanonicalEvidenceType.getAllXSDs ()),
                                  new eu.de4a.iem.jaxb.do_im.ObjectFactory ()::createResponseExtractEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <RequestExtractEvidenceUSIType> doUsiRequestMarshaller ()
  {
    return new DE4AMarshaller <> (RequestExtractEvidenceUSIType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DO_USI, null),
                                  new eu.de4a.iem.jaxb.do_usi.ObjectFactory ()::createRequestExtractEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseErrorType> doUsiResponseMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseErrorType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DO_USI, null),
                                  new eu.de4a.iem.jaxb.do_usi.ObjectFactory ()::createResponseExtractEvidence);
  }

  // Data Requestor

  @Nonnull
  public static DE4AMarshaller <RequestTransferEvidenceUSIIMDRType> drImRequestMarshaller ()
  {
    return new DE4AMarshaller <> (RequestTransferEvidenceUSIIMDRType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_DE_IM, null),
                                  new eu.de4a.iem.jaxb.dr_im.ObjectFactory ()::createRequestTransferEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseTransferEvidenceType> drImResponseMarshaller (@Nonnull final IDE4ACanonicalEvidenceType aCanonicalEvidenceType)
  {
    return new DE4AMarshaller <> (ResponseTransferEvidenceType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_DE_IM, aCanonicalEvidenceType.getAllXSDs ()),
                                  new eu.de4a.iem.jaxb.dr_im.ObjectFactory ()::createResponseTransferEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <RequestTransferEvidenceUSIIMDRType> drUsiRequestMarshaller ()
  {
    return new DE4AMarshaller <> (RequestTransferEvidenceUSIIMDRType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_USI, null),
                                  new eu.de4a.iem.jaxb.dr_usi.ObjectFactory ()::createRequestTransferEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseErrorType> drUsiResponseMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseErrorType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_USI, null),
                                  new eu.de4a.iem.jaxb.dr_usi.ObjectFactory ()::createResponseTransferEvidence);
  }

  // Data Transferor

  @Nonnull
  public static DE4AMarshaller <RequestTransferEvidenceUSIDTType> dtUsiRequestMarshaller (@Nonnull final IDE4ACanonicalEvidenceType aCanonicalEvidenceType)
  {
    return new DE4AMarshaller <> (RequestTransferEvidenceUSIDTType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DT_USI, aCanonicalEvidenceType.getAllXSDs ()),
                                  new eu.de4a.iem.jaxb.dt_usi.ObjectFactory ()::createRequestTransferEvidence);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseErrorType> dtUsiResponseMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseErrorType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DT_USI, null),
                                  new eu.de4a.iem.jaxb.dt_usi.ObjectFactory ()::createResponseTransferEvidence);
  }

  // Redirect

  @Nonnull
  public static DE4AMarshaller <RequestUserRedirectionType> deUsiRedirectRequestMarshaller ()
  {
    return new DE4AMarshaller <> (RequestUserRedirectionType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DE_DO_USI, null),
                                  new eu.de4a.iem.jaxb.de_usi.ObjectFactory ()::createRequestUserRedirection);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseUserRedirectionType> deUsiRedirectResponseMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseUserRedirectionType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DE_DO_USI, null),
                                  new eu.de4a.iem.jaxb.de_usi.ObjectFactory ()::createResponseUserRedirection);
  }

  // IDK

  @Nonnull
  public static DE4AMarshaller <RequestLookupRoutingInformationType> idkRequestLookupRoutingInformationMarshaller ()
  {
    return new DE4AMarshaller <> (RequestLookupRoutingInformationType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_DT_IDK, null),
                                  new eu.de4a.iem.jaxb.idk.ObjectFactory ()::createRequestLookupRoutingInformation);
  }

  @Nonnull
  public static DE4AMarshaller <ResponseLookupRoutingInformationType> idkResponseLookupRoutingInformationMarshaller ()
  {
    return new DE4AMarshaller <> (ResponseLookupRoutingInformationType.class,
                                  _getXSDs (CDE4AJAXB.XSD_DR_DT_IDK, null),
                                  new eu.de4a.iem.jaxb.idk.ObjectFactory ()::createResponseLookupRoutingInformation);
  }
}
