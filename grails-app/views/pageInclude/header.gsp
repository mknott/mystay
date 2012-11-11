<header data-role="header" data-position="fixed" class="condensed">
    <section class="links clearfix">
        <ul>
            <li>
                <g:if test="${cookie(name:'visitId')}">
                  <g:link controller="MyDetails" action="index" class="modal">my Details</g:link>
                </g:if>
                <g:else>
                  <span controller="newProfile" action="tellus" class="modal">Create a profile</span>
                </g:else>
            </li>
            <li><span href="../staticpages/modal-needhelp.html" class="modal">need Support</span></li>
            <li><!--<g:link controller="login" action="index">login</g:link>--></li>
        </ul>
    </section>
</header>


