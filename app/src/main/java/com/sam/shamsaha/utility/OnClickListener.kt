package com.sam.shamsaha.utility

import com.sam.shamsaha.volunteer.resources.VolCountryListAdapter

class OnClickListener (val clicklistener : (volCountryListAdapter: VolCountryListAdapter) -> Unit) {
    fun onClick(volCountryListAdapter: VolCountryListAdapter) = clicklistener (volCountryListAdapter)
}