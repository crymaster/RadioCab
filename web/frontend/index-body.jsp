<%-- 
    Document   : index-body
    Created on : Nov 23, 2014, 6:21:17 PM
    Author     : Son
--%>

<div class="slider_wrapper ">
    <div id="camera_wrap" class="">
        <div data-src="frontend/images/slide.jpg" ></div>
        <div data-src="frontend/images/slide1.jpg" ></div>
        <div data-src="frontend/images/slide2.jpg"></div>
    </div>
</div>
<div class="container_12">
    <div class="grid_4">
        <div class="banner">
            <div class="maxheight">
                <div class="banner_title">
                    <img src="frontend/images/icon1.png" alt="">
                    <div class="extra_wrapper">Fast&amp;
                        <div class="color1">Safe</div>
                    </div>
                </div>
                Dorem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad
                <a href="#" class="fa fa-share-square"></a>
            </div>
        </div>
    </div>
    <div class="grid_4">
        <div class="banner">
            <div class="maxheight">
                <div class="banner_title">
                    <img src="frontend/images/icon2.png" alt="">
                    <div class="extra_wrapper">Best
                        <div class="color1">Prices</div>
                    </div>
                </div>
                Hem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuader
                <a href="#" class="fa fa-share-square"></a>
            </div>
        </div>
    </div>
    <div class="grid_4">
        <div class="banner">
            <div class="maxheight">
                <div class="banner_title">
                    <img src="frontend/images/icon3.png" alt="">
                    <div class="extra_wrapper">Package
                        <div class="color1">Delivery</div>
                    </div>
                </div>
                Kurem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuki
                <a href="#" class="fa fa-share-square"></a>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="c_phone">
    <div class="container_12">
        <div class="grid_12">
            <div class="fa fa-phone"></div>+ 1800 559 6580
            <span>ORDER NOW!</span>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--==============================Content=================================-->
<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 07, 2014!</div>
    <div class="container_12">
        <div class="grid_5">
            <h3>Booking Form</h3>
            <form id="bookingForm">
                <div class="fl1">
                    <div class="tmInput">
                        <input name="Name" placeHolder="Name:" type="text" data-constraints='@NotEmpty @Required @AlphaSpecial'>
                    </div>
                    <div class="tmInput">
                        <input name="From" placeHolder="From:" type="text" data-constraints="@NotEmpty @Required ">
                    </div>
                </div>
                <div class="fl1">
                    <div class="tmInput">
                        <input name="Email" placeHolder="Email:" type="text" data-constraints="@NotEmpty @Required @Email">
                    </div>
                    <div class="tmInput mr0">
                        <input name="To" placeHolder="To:" type="text" data-constraints="@NotEmpty @Required">
                    </div>
                </div>
                <div class="clear"></div>
                <strong>Time</strong>
                <div class="tmInput">
                    <input name="Time" placeHolder="" type="text" data-constraints="@NotEmpty @Required">
                </div>
                <div class="clear"></div>
                <strong>Date</strong>
                <label class="tmDatepicker">
                    <input type="text" name="Date"	placeHolder='20/05/2014' data-constraints="@NotEmpty @Required @Date">
                </label>
                <div class="clear"></div>
                <div class="tmRadio">
                    <p>Comfort</p>
                    <input name="Comfort" type="radio" id="tmRadio0" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' checked/>
                    <span>Cheap</span>
                    <input name="Comfort" type="radio" id="tmRadio1" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' />
                    <span>Standart</span>
                    <input name="Comfort" type="radio" id="tmRadio2" data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' />
                    <span>Lux</span>
                </div>
                <div class="clear"></div>
                <div class="fl1 fl2">
                    <em>Adults</em>
                    <select name="Adults" class="tmSelect auto" data-class="tmSelect tmSelect2" data-constraints="">
                        <option>1</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                    <div class="clear height1"></div>
                </div>
                <div class="fl1 fl2">
                    <em>Children</em>
                    <select name="Children" class="tmSelect auto" data-class="tmSelect tmSelect2" data-constraints="">
                        <option>0</option>
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                    </select>
                </div>
                <div class="clear"></div>
                <div class="tmTextarea">
                    <textarea name="Message" placeHolder="Message" data-constraints='@NotEmpty @Required @Length(min=20,max=999999)'></textarea>
                </div>
                <a href="#" class="btn" data-type="submit">Submit</a>
            </form>
        </div>
        <div class="grid_6 prefix_1">
            <a href="index2.html" class="type"><img src="frontend/images/page1_img1.jpg" alt=""><span class="type_caption">Economy</span></a>
            <a href="index2.html" class="type"><img src="frontend/images/page1_img2.jpg" alt=""><span class="type_caption">Standard</span></a>
            <a href="index2.html" class="type"><img src="frontend/images/page1_img3.jpg" alt=""><span class="type_caption">Lux</span></a>
        </div>
        <div class="clear"></div>
    </div>
</div>
</div>
