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
import com.remya.communityfordevelopers.models.ItemModel
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
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()))
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
        items.add(ItemModel(R.drawable.app_icon, "Remya Raj", "21", "Android Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "19", "React Native"))
        items.add(ItemModel(R.drawable.app_icon, "Ohid Behna", "21", "IOS Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandita Saha", "21", "Web Developer"))
        items.add(ItemModel(R.drawable.app_icon, "Bonuuuu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.app_icon, "Sriparna", "20", "Backend Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "21", "Backend Develper"))
        items.add(ItemModel(R.drawable.app_icon, "Remya Raj", "21", "Android Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "19", "React Native"))
        items.add(ItemModel(R.drawable.app_icon, "Ohid Behna", "21", "IOS Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandita Saha", "21", "Web Developer"))
        items.add(ItemModel(R.drawable.app_icon, "Bonuuuu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.app_icon, "Sriparna", "20", "Backend Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "21", "Backend Develper"))
        items.add(ItemModel(R.drawable.app_icon, "Remya Raj", "21", "Android Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "19", "React Native"))
        items.add(ItemModel(R.drawable.app_icon, "Ohid Behna", "21", "IOS Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandita Saha", "21", "Web Developer"))
        items.add(ItemModel(R.drawable.app_icon, "Bonuuuu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.app_icon, "Sriparna", "20", "Backend Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "21", "Backend Develper"))
        items.add(ItemModel(R.drawable.app_icon, "Remya Raj", "21", "Android Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "19", "React Native"))
        items.add(ItemModel(R.drawable.app_icon, "Ohid Behna", "21", "IOS Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandita Saha", "21", "Web Developer"))
        items.add(ItemModel(R.drawable.app_icon, "Bonuuuu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Nandu", "21", "UI/UX Designer"))
        items.add(ItemModel(R.drawable.app_icon, "Sriparna", "20", "Backend Developer"))
        items.add(ItemModel(R.drawable.coding_dribbble, "Sumit Keshari", "21", "Backend Develper"))
        return items
    }
}