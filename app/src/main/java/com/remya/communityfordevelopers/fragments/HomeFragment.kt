package com.remya.communityfordevelopers.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.remya.communityfordevelopers.CardStackAdapter
import com.remya.communityfordevelopers.ItemModel
import com.remya.communityfordevelopers.R
import com.remya.communityfordevelopers.callbacks.CardStackCallback
import com.remya.communityfordevelopers.databinding.FragmentHomeBinding
import com.yuyakaido.android.cardstackview.*


class HomeFragment : Fragment() {
    private val TAG = "DashboardActivity"
    private var manager: CardStackLayoutManager? = null
    private var adapter: CardStackAdapter? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()))
//        return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardStackView = binding.cardStackView
        manager = CardStackLayoutManager(requireContext(), object : CardStackListener {
            override fun onCardDragging(direction: Direction, ratio: Float) {
                Log.d(TAG, "onCardDragging: d=" + direction.name.toString() + " ratio=" + ratio)
            }

            override fun onCardSwiped(direction: Direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager?.topPosition + " d=" + direction)
                if (direction === Direction.Right) {
                    Toast.makeText(requireContext(), "Direction Right", Toast.LENGTH_SHORT).show()
                }
                if (direction === Direction.Top) {
                    Toast.makeText(requireContext(), "Direction Top", Toast.LENGTH_SHORT).show()
                }
                if (direction === Direction.Left) {
                    Toast.makeText(requireContext(), "Direction Left", Toast.LENGTH_SHORT).show()
                }
                if (direction === Direction.Bottom) {
                    Toast.makeText(requireContext(), "Direction Bottom", Toast.LENGTH_SHORT).show()
                }

                // Paginating
                if (manager?.topPosition == adapter!!.itemCount - 5) {
                    paginate()
                }
            }

            override fun onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager!!.topPosition)
            }

            override fun onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager!!.topPosition)
            }

            override fun onCardAppeared(view: View, position: Int) {
                val tv: TextView = view.findViewById(R.id.item_name)
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.text)
            }

            override fun onCardDisappeared(view: View, position: Int) {
                val tv: TextView = view.findViewById(R.id.item_name)
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.text)
            }
        })
        manager?.setStackFrom(StackFrom.None)
        manager?.setVisibleCount(3)
        manager?.setTranslationInterval(8.0f)
        manager?.setScaleInterval(0.95f)
        manager?.setSwipeThreshold(0.3f)
        manager?.setMaxDegree(20.0f)
        manager?.setDirections(Direction.FREEDOM)
        manager?.setCanScrollHorizontal(true)
        manager?.setSwipeableMethod(SwipeableMethod.Manual)
        manager?.setOverlayInterpolator(LinearInterpolator())
        adapter = CardStackAdapter(addList()!!)
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator = DefaultItemAnimator()
    }

    private fun paginate() {
        val old = adapter!!.getItems()
        val baru: List<ItemModel> = ArrayList(addList())
        val callback = CardStackCallback(old, baru)
        val hasil = DiffUtil.calculateDiff(callback)
        adapter!!.setItems(baru)
        hasil.dispatchUpdatesTo(adapter!!)
    }

    private fun addList(): List<ItemModel>? {
        val items: MutableList<ItemModel> = ArrayList()
        items.add(ItemModel(R.drawable.app_icon, "Markonah", "24", "Jember"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Marpuah", "20", "Malang"))
        items.add(ItemModel(R.drawable.app_icon, "Sukijah", "27", "Jonggol"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Markobar", "19", "Bandung"))
        items.add(ItemModel(R.drawable.app_icon, "Marmut", "25", "Hutan"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Markonah", "24", "Jember"))
        items.add(ItemModel(R.drawable.app_icon, "Marpuah", "20", "Malang"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sukijah", "27", "Jonggol"))
        items.add(ItemModel(R.drawable.app_icon, "Markobar", "19", "Bandung"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Marmut", "25", "Hutan"))
        return items
    }
}