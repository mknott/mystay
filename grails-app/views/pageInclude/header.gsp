<header data-role="header" data-position="fixed" class="condensed image">
  <div class="target"></div>
    <section class="links clearfix">
        <ul>
 <!--           <li><g:link controller="locationDetails" action="index" class="modal modal-close">Home</g:link></li>-->
            <li>
                <g:if test="${cookie(name:'visitId')}">
                  <g:link controller="MyDetails" action="index" class="modal">My Details</g:link>
                </g:if>
                <g:else>
                  <span controller="newProfile" action="tellus" class="modal">Create a profile</span>
                </g:else>
            </li>
            <li><span href="MyStayApp/staticpages/modal-needhelp.html" class="modal">Need Support</span></li>
            <li><!--<g:link controller="login" action="index">login</g:link>--></li>
        </ul>
    </section>
</header>


