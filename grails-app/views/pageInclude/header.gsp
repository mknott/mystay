<header data-role="header" data-position="fixed" class="condensed">
    <section class="header links clearfix">
        <ul>
            <li>
              <g:if test="${cookie(name:'visitId')}">
                <g:link controller="locationDetails" action="index" class="ui-link">Home</g:link>
              </g:if>
            </li>
            <li>
              <g:if test="${cookie(name:'visitId')}">
                <g:link controller="MyDetails" action="index" class="modal">My Details</g:link>
              </g:if>
            </li>
            <li>
              <g:if test="${cookie(name:'visitId')}">
                <g:link controller="LocationDetails" action="propertyInfo" class="modal">Need Support</g:link>
              </g:if>
            </li>
            <!--li><g:link controller="login" action="index">login</g:link></li-->
        </ul>
    </section>
</header>


