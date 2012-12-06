<div class="modal_content">
  <div class="modal-title">Order Room Service</div>
  <dl>
      <dd>
        <b>Item: </b>${menuItem.name}</br>
        <b>Description: </b>${menuItem.caption}</b><br>
        <b>Options: </b>${menuItem.message}</b>
      </dd>
  </dl>
  <dl>  
      <dd>
        <g:form url="[action:'index',controller:'chatExisting']" method="post">
            <div align="center">
              <input type="hidden" name="chat_topic" id="chat_topic" value="RoomSvc" />
              <textarea name="chat_input" placeholder="Special instructions" id="chat_input">
I would like an order of ${menuItem.name}
Here are my special instructions:  
              </textarea>
              <button>place order</button>
            </div>
        </g:form>
      </dd>
  </dl>
  <dl>
      <dt>How it works</dt>
      <dd>
        Upon ordering an item, you will be placed in a live chat session 
        with a hotel representative.  You will be able to communicate any special 
        instructions, delivery options, or receive assistance.  Payment will be 
        communicated through your room number and hotel bill.
        <br><br>
        Don't see what you need, 
        <g:link class="cta-blue ui-link modal-close" controller="chatNew" action="index" params="[module_id:params.module_id]"> chat with us </g:link>
      </dd>
  </dl>
     
  <dl>
      <a href="#" class="cta-blue modal-close">close</a>
            </div>
          </dd>
  </dl>
   
</div>